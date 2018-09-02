package cn.dgtp.com.dao;

import cn.dgtp.com.pojo.Role;

/**
 * 管理员验证判断,权限级别限制
 * */
public interface AdminLoginDao {
	/**
	 * 角色级别验证
	 * */
	public Role checkRole(Integer username);
}
