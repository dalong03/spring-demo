package com.fb.webdemo.common.entity;

import java.util.Date;

/**
 * 数据实体类
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = -189553143293410758L;

	protected String createUser;// 创建人
	protected Date createDate;// 创建时间
	protected String updateUser;// 更新人
	protected Date updateDate;// 更新时间

	public DataEntity() {
		super();
	}

	public DataEntity(String id) {
		super(id);
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
