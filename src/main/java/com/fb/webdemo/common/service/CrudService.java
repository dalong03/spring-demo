package com.fb.webdemo.common.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface CrudService<T> extends BaseService {
	
	/**
	 * 获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	public T get(String id);

	/**
	 * 获取单条数据
	 * 
	 * @param T
	 * @return
	 */
	T get(T t);
	
	/**
	 * 获取数量
	 * 
	 * @param T
	 * @return
	 */
	int getCount(T t);
	
	/**
	 * 分页查询
	 * @param t
	 * @return
	 */
	PageInfo<T> findPage(T t);
	
	/**
	 * 获取多条数据
	 * 
	 * @param T
	 * @return
	 */
	List<T> findList(T t);

	/**
	 * 获取全部数据
	 * 
	 * @param T
	 * @return
	 */
	List<T> findAllList(T t);

	/**
	 * 保存数据
	 * 
	 * @param T
	 * @return
	 */
	int save(T t);

	/**
	 * 更新数据
	 * 
	 * @param T
	 * @return
	 */
	int update(T t);

	/**
	 * 更新数据
	 * 
	 * @param T
	 * @return
	 */
	int delete(String id);
	
	/**
	 * 更新数据
	 * 
	 * @param T
	 * @return
	 */
	int delete(T t);
}
