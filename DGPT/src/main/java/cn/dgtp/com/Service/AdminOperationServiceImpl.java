package cn.dgtp.com.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dgtp.com.Exception.ServiceException;
import cn.dgtp.com.Service.Serviceinterface.AdminOperationService;
import cn.dgtp.com.dao.AdminOperationDao;
import cn.dgtp.com.pojo.Admin;
import cn.dgtp.com.pojo.permissions;

@Service
public class AdminOperationServiceImpl implements AdminOperationService{
	
	@Autowired
	private AdminOperationDao dao;
	
	/**
	 * 用户注册
	 * */
	public void insertUser(Admin admin,Integer roleId) {
		if (dao.findAdminById(admin.getId())!=null) {
			throw new ServiceException("该账户以被注册");
		}
		if (roleId==permissions.root) {
			admin.setR_id("root");
		}else if (roleId==permissions.Teacher) {
			admin.setR_id("thr");
		}else if (roleId==permissions.Student) {
			admin.setR_id("std");
		}
		if(dao.insertUser(admin)!=1) {
			throw new ServiceException("录入失败");
		}
	}

	@Override
	public Map<String, Object> CheckByName(Integer username,String pwd) {
		Map<String, Object> map = new HashMap<String,Object>();
		Admin admin = null;
		if((admin = dao.findAdminById(username))==null) {
			throw new ServiceException("用户名或密码错误");
		}
		if (admin.getPwd().equals(pwd)) {
			map.put("admin", admin);
			map.put("boolean", true);
			return map;
		}
		map.put("admin", admin);
		map.put("boolean", false);
		return map;
	}

	public Admin findById(Integer id) {
		Admin admin = dao.findAdminById(id);
		return admin;
	}
	
	/**
	 * 修改用户
	 * */
	public void UpdateUser(Admin admin) {
		if(dao.update(admin)!=1) {
			throw new ServiceException("修改失败");
		}
	}
}
