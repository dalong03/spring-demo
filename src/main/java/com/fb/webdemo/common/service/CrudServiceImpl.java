package com.fb.webdemo.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fb.webdemo.common.dao.CrudDao;
import com.fb.webdemo.common.entity.BaseEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class CrudServiceImpl<D extends CrudDao<T>, T extends BaseEntity<T>> implements CrudService<T> {

	@Autowired
	protected D crudDao;

	@Override
	public T get(String id) {
		return crudDao.get(id);
	}

	@Override
	public T get(T t) {
		return crudDao.get(t);
	}

	@Override
	public int getCount(T t) {
		return crudDao.getCount(t);
	}

	@Override
	public PageInfo<T> findPage(T t) {
		PageInfo<T> pageInfo = t.getPageInfo();
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		return new PageInfo<T>(crudDao.findList(t));
	}

	@Override
	public List<T> findList(T t) {
		return crudDao.findList(t);
	}

	@Override
	public List<T> findAllList(T t) {
		return crudDao.findAllList(t);
	}

	@Override
	@Transactional
	public int save(T t) {
		return crudDao.save(t);
	}

	@Override
	@Transactional
	public int update(T t) {
		return crudDao.update(t);
	}

	@Override
	@Transactional
	public int delete(T t) {
		return crudDao.delete(t);
	}

	@Override
	@Transactional
	public int delete(String id) {
		return crudDao.delete(id);
	}

}
