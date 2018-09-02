package cn.dgtp.com.dao;

import cn.dgtp.com.pojo.Admin;

public interface AdminOperationDao {
	/**
	 * 录入用户
	 * */
	public int insertUser(Admin admin);
	
	/**
	 * 根据id查找用户
	 * */
	public Admin findAdminById(Integer username);
	
	/**
	 * 修改信息
	 * */
	public int update(Admin admin);
}
