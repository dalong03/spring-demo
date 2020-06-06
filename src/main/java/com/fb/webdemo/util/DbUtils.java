package com.fb.webdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DbUtils {
	public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/fb?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=CTT";
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "Fb123456";
	public static Connection c = null;
	private static final Logger logger = LoggerFactory.getLogger(DbUtils.class);

	static {
		try {
			Class.forName(DRIVER_CLASS);
			logger.info("加载数据库驱动类");
			c = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			logger.info("与数据库建立连接");
		} catch (ClassNotFoundException e) {
			logger.error("加载数据库驱动类失败");
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error("与数据库建立连接失败");
			e.printStackTrace();
		}
	}

	private DbUtils() {
	}

	public static Connection getConnection() {
		logger.info("获取Connection");
		return c;
	}

	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
				logger.info("关闭数据库连接");
			} catch (SQLException e) {
				logger.error("关闭数据库连接失败");
				e.printStackTrace();
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement p) {
		if (p != null) {
			try {
				p.close();
				logger.info("关闭PreparedStatement");
			} catch (SQLException e) {
				logger.error("关闭sql语句失败");
				e.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet r) {
		if (r != null) {
			try {
				r.close();
				logger.info("关闭ResultSet");
			} catch (SQLException e) {
				logger.error("关闭sql结果集失败");
				e.printStackTrace();
			}
		}
	}
}