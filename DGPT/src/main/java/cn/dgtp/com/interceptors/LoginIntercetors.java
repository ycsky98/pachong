package cn.dgtp.com.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.dgtp.com.pojo.Admin;

/**
 * 验证拦截
 * */
public class LoginIntercetors implements HandlerInterceptor{

	/**
	 * 判断
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * 登陆拦截
		 * */
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("check");
		
		if (map == null) {
			/*--跳转到登录页面--*/
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		//获取验证信息
		Boolean falg = (Boolean)map.get("boolean");
		Admin admin = (Admin)map.get("admin");
		
		if (falg) {
			//如果验证成功,则判断该账号是否已经登录
			//获取用户监听
			Map<String, String> smap =
					(Map<String, String>)request.getSession().getServletContext().getAttribute("LoginListenerMap");
			//如果和当前的sessionid相同
			if (smap.containsValue(request.getSession().getId())) {
				System.out.println("相同则登录");
				return true;
			}else if (smap.get(String.valueOf(admin.getId()))==null) {//如果未登录过,则登录
				System.out.println("未登陆则登录");
				smap.put(String.valueOf(admin.getId()), request.getSession().getId());
				request.getSession().getServletContext().setAttribute("LoginListenerMap", smap);
				/*---存入每个客户端的session---*/
				@SuppressWarnings("unchecked")
				Map<String, HttpSession> setsession =
						(Map<String, HttpSession>)request.getSession().getServletContext().getAttribute("session");
				setsession.put(String.valueOf(admin.getId()), request.getSession());
				request.getSession().getServletContext().setAttribute("session", setsession);
				return true;
			}else {//重复登录则替换sessionid和销毁原session
				System.out.println("重置");
				/*---存入每个客户端的session---*/
				@SuppressWarnings("unchecked")
				Map<String, HttpSession> setsession =
						(Map<String, HttpSession>)request.getSession().getServletContext().getAttribute("session");
				if (setsession.get(String.valueOf(admin.getId()))!=null) {
					//如果存入过,则删除session信息
					/*--清空session--*/
					setsession.get(String.valueOf(admin.getId())).invalidate();
					setsession.put(String.valueOf(admin.getId()), request.getSession());
					//重新绑定
					request.getSession().getServletContext().setAttribute("session", setsession);
					request.getSession().setAttribute("check", map);
				}
				smap.put(String.valueOf(admin.getId()), request.getSession().getId());
				/*--重新设置sessionid--*/
				request.getSession().getServletContext().setAttribute("LoginListenerMap", smap);
				return true;
			}
		}
		//跳到登录页面
		response.sendRedirect(request.getContextPath()+"/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
