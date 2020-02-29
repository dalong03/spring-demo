package com.fb.webdemo.entity;

import com.fb.webdemo.common.entity.DataEntity;

public class Result extends DataEntity<Result> {
	private static final long serialVersionUID = 5184013528145785965L;
	private Integer item1Count;
	private Integer item2Count;
	private Integer item3Count;

	public Integer getItem1Count() {
		return item1Count;
	}

	public void setItem1Count(Integer item1Count) {
		this.item1Count = item1Count;
	}

	public Integer getItem2Count() {
		return item2Count;
	}

	public void setItem2Count(Integer item2Count) {
		this.item2Count = item2Count;
	}

	public Integer getItem3Count() {
		return item3Count;
	}

	public void setItem3Count(Integer item3Count) {
		this.item3Count = item3Count;
	}
}
