package cn.dgtp.com.Service.Serviceinterface;

public interface LoginCheckService {
	
	/**
	 * 检测用户登录权限
	 * */
	public Integer checkLogin(Integer username);
}
