package com.baobaotao.service;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestUserService extends TestCase {

	@Autowired
	private UserService userService;

	@Test
	public void hasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "1111");
		assertTrue(b1);
		assertFalse(b2);
	}
	
	@Test
	public void findUserByUserName(){
		User user = userService.findUserByUserName("admin");
		assertEquals("admin",user.getUserName());
	}
	
	@Test
	public void loginSuccess(){
		User user = userService.findUserByUserName("admin");
		user.setLastIp("127.0.0.1");
		user.setLastVisit(new Date());
		
		userService.loginSuccess(user);
	}

}
