package com.fb.webdemo.jdbc.dao;

import java.util.List;

import com.fb.webdemo.jdbc.entity.A;

public interface ADao {

	A get(String id);
	
	List<A> findList(A a);
	
	void save(A t);

	void update(A t);
	
	void delete(String id);

}
