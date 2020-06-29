package com.fb.webdemo.common.entity;

import java.io.Serializable;

import com.fb.webdemo.util.PropertiesUtils;

/**
 * 基本实体类
 */

public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 3954371210534946930L;
	protected Integer id;

	public BaseEntity() {
	}

	public BaseEntity(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDbType(){
		return PropertiesUtils.getProperty("dbType");
	}
	
	public String getDbName(){
		return PropertiesUtils.getProperty("dbName");
	}
}
