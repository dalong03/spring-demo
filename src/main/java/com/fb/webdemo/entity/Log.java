package com.fb.webdemo.entity;

import com.fb.webdemo.common.entity.DataEntity;

/**
 * 日志实体类
 *
 */
public class Log extends DataEntity<Log> {

	private static final long serialVersionUID = 8649386528352519458L;

	/**
	 * 日志类型（1：登录；）
	 */
	public static final Integer TYPE_LOGIN = 1;
	/**
	 * 日志类型（2：业务异常）
	 */
	public static final Integer TYPE_BUSI_EXCEPTION = 2;
	/**
	 * 日志类型（3：系统异常）
	 */
	public static final Integer TYPE_SYS_EXCEPTION = 3;

	private Integer type; // 日志类型（1：接入日志；2：错误日志）
	private String exSynopsis; // 异常信息摘要
	private String exception; // 异常信息
	private String ipAddr; // 访问者ip
	private String userAgent; // 操作用户代理信息
	private String requestUri; // 操作的URI
	private String method; // 操作的方式
	private String params; // 操作提交的数据

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getExSynopsis() {
		return exSynopsis;
	}

	public void setExSynopsis(String exSynopsis) {
		this.exSynopsis = exSynopsis;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
