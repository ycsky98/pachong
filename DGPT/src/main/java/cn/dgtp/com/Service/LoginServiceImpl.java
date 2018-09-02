package cn.dgtp.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dgtp.com.Exception.ServiceException;
import cn.dgtp.com.Service.Serviceinterface.LoginCheckService;
import cn.dgtp.com.dao.AdminLoginDao;
import cn.dgtp.com.dao.AdminOperationDao;
import cn.dgtp.com.pojo.Admin;
import cn.dgtp.com.pojo.Role;

/**
 * 登陆验证及权限检测
 * */
@Service
public class LoginServiceImpl implements LoginCheckService{

	/**
	 * 调用logindao
	 * */
	@Autowired
	private AdminLoginDao dao;
	
	@Autowired
	private AdminOperationDao dao2;
	
	/**
	 * 权限检测
	 * */
	public Integer checkLogin(Integer username) {
		Admin admin = dao2.findAdminById(username);
		/**
		 * 获取角色
		 * */
		Role role = dao.checkRole(admin.getId());
		if (role==null) {
			throw new ServiceException("");
		}
		return role.getP_id();
	}

}
