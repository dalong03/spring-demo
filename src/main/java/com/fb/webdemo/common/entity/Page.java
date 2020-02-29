package com.fb.webdemo.common.entity;

import java.util.ArrayList;
import java.util.List;

import com.fb.webdemo.util.PropertiesUtils;

public class Page<T> {
	private int pageNo = 1; // 当前页码
	private int pageSize = Integer.valueOf(PropertiesUtils.getProperty("pageSize"));// 每页记录数
	private long count;// 总记录数，设置为“-1”表示不查询总数
	private List<T> list = new ArrayList<T>();

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
