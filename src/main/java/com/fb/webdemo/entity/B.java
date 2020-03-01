package com.fb.webdemo.entity;

public class B {

	private String id;

	private Integer age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "A [id=" + id + ", age=" + age + "]";
	}

}
