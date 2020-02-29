package com.fb.webdemo.dao;

import java.util.List;

import com.fb.webdemo.common.dao.CrudDao;
import com.fb.webdemo.entity.Details;

public interface DetailsDao extends CrudDao<Details>{

	int batchSave(List<Details> list);
}
