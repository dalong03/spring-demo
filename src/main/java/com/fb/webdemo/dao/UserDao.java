package com.fb.webdemo.dao;

import com.fb.webdemo.common.dao.CrudDao;
import com.fb.webdemo.entity.User;

public interface UserDao extends CrudDao<User>{
	User get(User user);
}
