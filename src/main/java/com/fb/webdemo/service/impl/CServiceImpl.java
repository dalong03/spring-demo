package com.fb.webdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.webdemo.common.multidatasource.DynamicDataSource;
import com.fb.webdemo.common.multidatasource.annotation.DataSource;
import com.fb.webdemo.dao.CDao;
import com.fb.webdemo.entity.C;
import com.fb.webdemo.service.CService;

@Service
public class CServiceImpl implements CService {
	@Autowired
	private CDao cDao;

	@Override
	@DataSource(DynamicDataSource.DATASOURCE2)
	public C get(String id) {
		return cDao.get(id);
	}

	@Override
	@DataSource(DynamicDataSource.DATASOURCE2)
	public List<C> findList(C c) {
		return cDao.findList(c);
	}
	
	@Override
	@DataSource(DynamicDataSource.DATASOURCE2)
	public C save(C c) {
		cDao.save(c);
		return c;
	}

	@Override
	@DataSource(DynamicDataSource.DATASOURCE2)
	public C update(C c) {
		return null;
	}

	@Override
	@DataSource(DynamicDataSource.DATASOURCE2)
	public C delete(String id) {
		return null;
	}

}
