package com.fb.webdemo.entity;

import com.fb.webdemo.common.entity.DataEntity;

/**
 * 菜单实体类
 *
 */
public class Menu extends DataEntity<Menu> {

	private static final long serialVersionUID = 8649386528352519458L;
	private String url;
	private String name;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
