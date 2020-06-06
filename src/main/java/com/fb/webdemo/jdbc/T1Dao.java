package com.fb.webdemo.jdbc;

import java.util.List;

import com.fb.webdemo.entity.T1;

public interface T1Dao {

	T1 get(String id);
	
	List<T1> findList(T1 a);
	
	void save(T1 t1);

	void update(T1 t1);
	
	void delete(String id);

}
