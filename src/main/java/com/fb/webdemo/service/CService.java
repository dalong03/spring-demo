package com.fb.webdemo.service;

import java.util.List;

import com.fb.webdemo.entity.C;

public interface CService {

	C get(String id);

	List<C> findList(C c);

	C save(C c);

	C update(C c);

	C delete(String id);
}
