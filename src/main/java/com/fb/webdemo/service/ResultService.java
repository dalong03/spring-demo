package com.fb.webdemo.service;

import com.fb.webdemo.common.service.CrudService;
import com.fb.webdemo.entity.Result;

public interface ResultService extends CrudService<Result>{
	int save(String items1, String items2, String items3);
}
