/**
 * Copyright (c) 2005-2012 springside.org.cn
 */
package com.fb.webdemo.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.UncategorizedSQLException;

/**
 * 关于异常的工具类.
 * @author calvin
 * @version 2013-01-15
 */
public class Exceptions {

	/**
	 * 将CheckedException转换为UncheckedException.
	 */
	public static RuntimeException unchecked(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}

	/**
	 * 将ErrorStack转化为String.
	 */
	public static String getStackTraceAsString(Throwable e) {
		if (e == null){
			return null;
		}
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}
	
	/**
	 * 获取异常摘要.
	 */
	public static String getExSynopsis(Throwable e) {
		if(e == null){
			return null;
		}
		String exSynopsis = null;
		if (e instanceof BusinessException) {
			exSynopsis = e.getMessage();
		} else {
			if (e instanceof SQLException) {
				exSynopsis = "SQL语句异常";
			} else if (e instanceof UncategorizedSQLException) {
				exSynopsis = "未申明的SQL语句异常";
			} else if (e instanceof NullPointerException) {
				exSynopsis = "空指针异常";
			} else if (e instanceof ArrayIndexOutOfBoundsException || e instanceof IndexOutOfBoundsException) {
				exSynopsis = "索引超出下标";
			} else {
				exSynopsis = "系统异常";
			}
		}
		return exSynopsis;
	}

	/**
	 * 判断异常是否由某些底层的异常引起.
	 */
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		Throwable cause = ex.getCause();
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}

	/**
	 * 在request中获取异常类
	 * @param request
	 * @return 
	 */
	public static Throwable getThrowable(HttpServletRequest request){
		Throwable ex = null;
		if (request.getAttribute("exception") != null) {
			ex = (Throwable) request.getAttribute("exception");
		} else if (request.getAttribute("javax.servlet.error.exception") != null) {
			ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
		}
		return ex;
	}
	
}
