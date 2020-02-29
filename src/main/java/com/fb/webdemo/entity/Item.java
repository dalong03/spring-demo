package com.fb.webdemo.entity;

import java.util.List;

import com.fb.webdemo.common.entity.DataEntity;

public class Item extends DataEntity<Item> {
	private static final long serialVersionUID = -6934140265825594437L;
	public static final Integer ITEM_LEVEL_1 = 1;
	public static final Integer ITEM_LEVEL_2 = 2;
	public static final Integer ITEM_LEVEL_3 = 3;
	private String name;
	private String parentId;
	private Integer itemLevel;
	private Integer sort;
	private List<Item> items;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getItemLevel() {
		return itemLevel;
	}

	public void setItemLevel(Integer itemLevel) {
		this.itemLevel = itemLevel;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
