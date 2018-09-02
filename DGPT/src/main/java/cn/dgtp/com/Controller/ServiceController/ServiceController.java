package cn.dgtp.com.Controller.ServiceController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dgtp.com.Service.Serviceinterface.AdminOperationService;
import cn.dgtp.com.Service.Serviceinterface.LoginCheckService;
import cn.dgtp.com.Web.JsonResult;
import cn.dgtp.com.pojo.Admin;

/**
 * 业务接口
 * */
@Controller
public class ServiceController {
	
	@Autowired
	private LoginCheckService impl;
	
	@Autowired
	private AdminOperationService impl2;
	
	/**
	 * 权限检测接口
	 * */
	@RequestMapping(value="/checkRole")
	@ResponseBody
	public JsonResult checkRole(Integer username,String pwd,HttpServletRequest request) {
		/**
		 * 检测前先清除当前用户的session
		 * */
		request.getSession().invalidate();
		
		Map<String, Object> map = new HashMap<String,Object>();
		Map<String, Object> map2= impl2.CheckByName(username,pwd);
		map.put("role", impl.checkLogin(username));
		map.put("check", map2);
		request.getSession().setAttribute("check", map2);
		Admin admin = (Admin)map2.get("admin");
		request.getSession().setAttribute("result", map);
		/*System.out.println(username+","+pwd+","+map2.get("boolean"));*/
		/*----以上是用户校验信息----*/
		/*----------------------------------------------------------------------------*/
		return new JsonResult(map);
	}
	
	/**
	 * 录入用户接口
	 * */
	@RequestMapping(value="/insertUser",method= {RequestMethod.POST})
	@ResponseBody
	public JsonResult insertUser(Admin admin,HttpServletRequest request) {
		System.out.println(admin);
		impl2.insertUser(admin, Integer.parseInt(admin.getR_id()));
		return new JsonResult();
	}
	
	/**
	 * 获取当前登录的用户
	 * */
	@RequestMapping(value="/LoginUser",method= {RequestMethod.POST})
	@ResponseBody
	public JsonResult getUser(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("check");
		if (map==null) {
			return new JsonResult();
		}
		Admin admin = (Admin)map.get("admin");
		return new JsonResult(admin.getId());
	}
	
	/**
	 * 查询用户
	 * */
	@RequestMapping(value="/findUserById")
	@ResponseBody
	public JsonResult findUserByID(String id) {
		return new JsonResult(impl2.findById(Integer.parseInt(id)));
	}
	
	/**
	 * 修改用户
	 * */
	@RequestMapping(value="/updateUser",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonResult toUpdate(Admin admin) {
		impl2.UpdateUser(admin);
		return new JsonResult();
	}
}
