package com.fb.webdemo.common.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class AbstractCrudService<T> implements CrudService<T> {

	@Override
	public T get(String id) {
		return null;
	}

	@Override
	public T get(T t) {
		return null;
	}

	@Override
	public int getCount(T t) {
		return 0;
	}

	@Override
	public PageInfo<T> findPage(T t, PageInfo<T> pageInfo) {
		return null;
	}

	@Override
	public List<T> findList(T t) {
		return null;
	}

	@Override
	public List<T> findAllList(T t) {
		return null;
	}

	@Override
	public int save(T t) {
		return 0;
	}

	@Override
	public int update(T t) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int delete(T t) {
		return 0;
	}

}
