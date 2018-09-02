package cn.dgtp.com.Exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dgtp.com.Web.JsonResult;

/**通过此注解声明此类是一个全局异常处理类*/
@ControllerAdvice
public class ControllerExceptionHandler {

	/**
	 * 当spring发现系统出现了异常,且异常的类型为你定义的类型,
	 * 此时就会回调此方法,并将异常值传递给这个对象的构造方法,
	 * 这个时候我们就可以在此方法中对业务异常进行处理
	 * */
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult handleServiceException(
			ServiceException serviceException){
		serviceException.printStackTrace();
		int a = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		/*
		 * 将异常封装到JsonResult
		 * */
		return new JsonResult(serviceException);
		//this.state=0
		//this.message=e.getMessage();
	}
}
