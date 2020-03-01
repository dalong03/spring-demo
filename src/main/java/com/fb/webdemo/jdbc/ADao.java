package com.fb.webdemo.jdbc;

import java.util.List;

import com.fb.webdemo.entity.A;

public interface ADao {

	A get(String id);
	
	List<A> findList(A a);
	
	void save(A t);

	void update(A t);
	
	void delete(String id);

}
