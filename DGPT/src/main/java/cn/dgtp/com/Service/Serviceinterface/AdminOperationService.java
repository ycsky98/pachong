package cn.dgtp.com.Service.Serviceinterface;

import java.util.Map;

import cn.dgtp.com.pojo.Admin;

public interface AdminOperationService {
	
	/**
	 * 插入用户数据
	 * */
	public void insertUser(Admin admin,Integer roleId);
	
	/**
	 * 根据用户名查找用户
	 * */
	public Map<String, Object> CheckByName(Integer username,String pwd);
	
	/**
	 * 查找用户
	 * */
	public Admin findById(Integer id);
	
	/**修改用户*/
	public void UpdateUser(Admin admin);
}
