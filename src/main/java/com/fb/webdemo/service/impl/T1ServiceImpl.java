package com.fb.webdemo.service.impl;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fb.webdemo.dao.T1Dao;
import com.fb.webdemo.entity.T1;
import com.fb.webdemo.service.T1Service;

@Service
public class T1ServiceImpl implements T1Service {
	@Autowired
	private T1Dao t1Dao;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public T1 get(String id) {
//		if(true) {
//		throw new RuntimeException("==");
//	}
		System.out.println(t1Dao.get(id));
		return t1Dao.get(id);
	}

	@Override
	@Transactional
	public T1 save(T1 t1) {

		t1Dao.save(t1);
		if (true) {
			throw new RuntimeException("==");
		}
		return t1;
	}

}
