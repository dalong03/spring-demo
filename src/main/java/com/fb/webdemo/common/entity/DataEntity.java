package com.fb.webdemo.common.entity;

import java.util.Date;

/**
 * 数据实体类
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = -189553143293410758L;

	public Integer createUser;// 创建人
	public Date createDate;// 创建时间
	public Integer updateUser;// 更新人
	public Date updateDate;// 更新时间

	public DataEntity() {
		super();
	}

	public DataEntity(Integer id) {
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

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

}
