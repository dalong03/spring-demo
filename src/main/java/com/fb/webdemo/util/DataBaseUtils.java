package com.fb.webdemo.util;

import com.baomidou.mybatisplus.generator.config.rules.DbType;

/**
 * 数据库的工具类
 * 
 * @author Administrator
 *
 */
public abstract class DataBaseUtils {

	public static final String TYPE_ORACLE = "oracle";
	public static final String TYPE_MYSQL = "mysql";
	public static final String TYPE_SQLSERVER = "sqlserver";
	
	/**
	 * 设置数据库的类型
	 * @param dbType
	 * @return
	 */
			
	public static DbType chooseDbType(String dbType) {
		switch (dbType) {
		case "oracle":
			return DbType.ORACLE;
		case "mysql":
			return DbType.MYSQL;
		default:
			return DbType.OTHER;
		}
	}
}
