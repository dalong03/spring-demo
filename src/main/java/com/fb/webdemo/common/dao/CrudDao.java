package com.fb.webdemo.common.dao;

import java.util.List;

/**
 * 持久层的增删改查
 * 
 * @param <T>
 */
public interface CrudDao<T> extends BaseDao {

	/**
	 * 获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	T get(String id);

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
	int delete(T t);

	/**
	 * 更新数据
	 * 
	 * @param T
	 * @return
	 */
	int delete(String id);
}
