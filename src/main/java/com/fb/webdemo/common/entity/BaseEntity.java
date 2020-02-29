package com.fb.webdemo.common.entity;

import java.io.Serializable;

import com.fb.webdemo.util.PropertiesUtils;
import com.github.pagehelper.PageInfo;

/**
 * 基本实体类
 */

public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 3954371210534946930L;
	protected String id;
	protected PageInfo<T> pageInfo;

	public PageInfo<T> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<T> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public BaseEntity() {
	}

	public BaseEntity(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDbType(){
		return PropertiesUtils.getProperty("dbType");
	}
	
	public String getDbName(){
		return PropertiesUtils.getProperty("dbName");
	}
}
