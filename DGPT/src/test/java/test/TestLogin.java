package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dgtp.com.dao.AdminLoginDao;
import cn.dgtp.com.dao.AdminOperationDao;
import cn.dgtp.com.pojo.Admin;

public class TestLogin {
	private ApplicationContext ctx =
			new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mybatis.xml","spring-pool.xml");

	private AdminLoginDao dao = null;
	
	private AdminOperationDao dao2;
	
	@Before
	public void init() {
		dao = ctx.getBean("adminLoginDao",AdminLoginDao.class);
		dao2 = ctx.getBean("adminOperationDao",AdminOperationDao.class);
	}
	
	@Test
	public void test1() {
		Admin admin = new Admin();
		admin.setId(123456);
		admin.setPwd("123");
		admin.setR_id("thr");
		admin.setEmail("555555@qq.com");
		//dao2.insertUser(admin);
		dao2.update(admin);
	}
	
	@Test
	public void test2() {
		System.out.println(dao.checkRole(123456));
	}
}
