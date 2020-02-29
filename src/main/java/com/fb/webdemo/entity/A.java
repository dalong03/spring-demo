package com.fb.webdemo.entity;



import java.util.Date;

import com.fb.webdemo.common.entity.DataEntity;

public class A extends DataEntity<A> {
	private static final long serialVersionUID = -3975052394122987047L;
	private String name;
	private Integer age;
	private Date birth;
	
	public A(){
		
	}
	
	public A(String id){
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


}
