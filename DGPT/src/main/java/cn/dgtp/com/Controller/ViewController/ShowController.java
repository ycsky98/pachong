package cn.dgtp.com.Controller.ViewController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 视图层
 * */
@Controller
public class ShowController {
	/**
	 * 注册
	 * */
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	/**
	 * 登录
	 * */
	@RequestMapping(value="/login",method= {RequestMethod.GET})
	public String login(HttpServletRequest request) {
		//System.out.println("登陆");
		return "login";
	}
	/**
	 * 注册
	 * */
	@RequestMapping(value="/registered")
	public String registered() {
		//System.out.println("注册");
		return "zc";
	}
	/**
	 * 修改
	 * */
	@RequestMapping(value="/update")
	public String update() {
		return "userinfo";
	}
	
	@RequestMapping("/shixi")
	public String shixi() {
		return "fieldwork";
	}
	
	@RequestMapping("/hj")
	public String getAwards() {
		return "getAwards";
	}
	
	@RequestMapping("/tinformation")
	public String THR() {
		return "tinformation";
	}
	
	@RequestMapping("/graduation")
	public String bs() {
		return "graduation";
	}
}
