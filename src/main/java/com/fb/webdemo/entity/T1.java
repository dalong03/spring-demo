package com.fb.webdemo.entity;

import com.fb.webdemo.common.entity.DataEntity;

public class T1 extends DataEntity<T1> {

	private static final long serialVersionUID = 8649386528352519458L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "T1 [name=" + name + "]";
	}

}
