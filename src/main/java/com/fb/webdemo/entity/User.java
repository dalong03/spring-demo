package com.fb.webdemo.entity;

import com.fb.webdemo.common.entity.DataEntity;

/**
 * 用户实体类
 *
 */
public class User extends DataEntity<User> {

	private static final long serialVersionUID = 4491027511439716031L;
	private String account;// 用户帐户
	private String name;// 名称
	private String password;// 密码

	public User() {

	}

	public User(Integer id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
