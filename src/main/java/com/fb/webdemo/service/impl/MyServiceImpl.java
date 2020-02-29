package com.fb.webdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fb.webdemo.common.service.CrudServiceImpl;
import com.fb.webdemo.dao.MyDao;
import com.fb.webdemo.entity.A;
import com.fb.webdemo.service.MyService;

@Service
public class MyServiceImpl extends CrudServiceImpl<MyDao, A> implements MyService {

	@Autowired
	private MyDao myDao;
	
	@Cacheable("aCache")
	public A get(String id){
		return myDao.get(id);
	}
}
