package com.fb.webdemo.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fb.webdemo.jdbc.T1Dao;
import com.fb.webdemo.entity.T1;
import com.fb.webdemo.util.DbUtils;

@Repository
public class T1DaoImpl implements T1Dao {

	private static final Logger logger = LoggerFactory.getLogger(T1DaoImpl.class);

	@Override
	public T1 get(String id) {
		PreparedStatement ps = null;
		try {
			Connection cn = DbUtils.getConnection();
			String sql = "select * from t1 where id = ?";
			logger.info(sql);
			logger.info(id);
			ps = cn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet set = ps.executeQuery();
			T1 t1 = null;
			if (set.next()) {
				t1 = new T1();
				t1.setId(id);
			}
			return t1;
		} catch (SQLException e) {
			logger.error("数据库操作失败");
			e.printStackTrace();
			throw new RuntimeException("数据库操作失败");
		} finally {
			DbUtils.closePreparedStatement(ps);
		}
	}

	@Override
	public List<T1> findList(T1 t1) {
		PreparedStatement ps = null;
		try {
			Connection cn = DbUtils.getConnection();
			StringBuffer sql = new StringBuffer("select * from t1 where 1 = 1 ");
			logger.info(sql.toString());
			logger.info(t1.toString());
			ps = cn.prepareStatement(sql.toString());
			ResultSet set = ps.executeQuery();
			List<T1> list = new ArrayList<>();
			T1 one = null;
			while (set.next()) {
				one = new T1();
				one.setId(set.getString(1));
				list.add(one);
			}
			return list;
		} catch (SQLException e) {
			logger.error("数据库操作失败");
			e.printStackTrace();
			throw new RuntimeException("数据库操作失败");
		} finally {
			DbUtils.closePreparedStatement(ps);
		}
	}

	@Override
	public void save(T1 t1) {
		PreparedStatement ps = null;
		try {
			Connection cn = DbUtils.getConnection();
			String sql = "insert into t1(id, age) values(?, ?)";
			logger.info(sql);
			logger.info(t1.toString());
			ps = cn.prepareStatement(sql);
			ps.setString(1, t1.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("数据库操作失败");
			e.printStackTrace();
			throw new RuntimeException("数据库操作失败");
		} finally {
			DbUtils.closePreparedStatement(ps);
		}
	}

	@Override
	public void update(T1 t1) {
		PreparedStatement ps = null;
		try {
			Connection cn = DbUtils.getConnection();
			StringBuffer sql = new StringBuffer("update t1");
			sql.append(" where id = ").append(t1.getId());
			logger.info(sql.toString());
			logger.info(t1.toString());
			ps = cn.prepareStatement(sql.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("数据库操作失败");
			e.printStackTrace();
			throw new RuntimeException("数据库操作失败");
		} finally {
			DbUtils.closePreparedStatement(ps);
		}
	}

	@Override
	public void delete(String id) {
		PreparedStatement ps = null;
		try {
			Connection cn = DbUtils.getConnection();
			String sql = "delete from t1 where id = ?";
			logger.info(sql.toString());
			logger.info(id);
			ps = cn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("数据库操作失败");
			e.printStackTrace();
			throw new RuntimeException("数据库操作失败");
		} finally {
			DbUtils.closePreparedStatement(ps);
		}
	}

}
