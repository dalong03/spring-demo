package com.fb.webdemo.util;

import com.fb.webdemo.dao.UserDao;
import com.fb.webdemo.entity.User;

public class UserUtils {
	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);

	public static User get(String id){
		User user = new User(id);
		return userDao.get(user);
	}
	
	public static User getUser(){
		return (User)SessionUtils.getSession().getAttribute("user");
	}
}
