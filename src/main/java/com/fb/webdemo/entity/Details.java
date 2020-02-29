package com.fb.webdemo.entity;

import com.fb.webdemo.common.entity.DataEntity;

public class Details extends DataEntity<Details> {
	private static final long serialVersionUID = 5184013528145785965L;
	private String resultId;
	private String itemId;
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
}
