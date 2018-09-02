package cn.pachong.com.contorller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.pachong.com.service.impServiceFind;

@Controller
@RequestMapping("/up")
public class ControllerFind {
	
	@Resource
	private impServiceFind find;
	
	@RequestMapping("/index")
	public String test(){
		find.pachong("https://www.douyu.com/directory/game/How");
		return null;
	}
}
