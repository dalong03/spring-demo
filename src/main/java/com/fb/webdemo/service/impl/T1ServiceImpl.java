package com.fb.webdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fb.webdemo.common.service.AbstractCrudService;
import com.fb.webdemo.dao.T1Dao;
import com.fb.webdemo.entity.T1;
import com.fb.webdemo.service.T1Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class T1ServiceImpl extends AbstractCrudService<T1> implements T1Service {
	@Autowired
	private T1Dao t1Dao;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public T1 get(String id) {
		System.out.println(t1Dao.get(id));
		return t1Dao.get(id);
	}
	
	@Override
	public PageInfo<T1> findPage(T1 t, PageInfo<T1> pageInfo) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<T1> list = t1Dao.findPage(t);
		PageInfo<T1> pageInfoRet = new PageInfo<T1>(list);
		return pageInfoRet;
	}

}
