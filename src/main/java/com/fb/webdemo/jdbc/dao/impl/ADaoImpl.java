package com.fb.webdemo.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fb.webdemo.jdbc.dao.ADao;
import com.fb.webdemo.jdbc.entity.A;
import com.fb.webdemo.util.DbUtils;

@Repository
public class ADaoImpl implements ADao {

	private static final Logger logger = LoggerFactory.getLogger(DbUtils.class);

	@Override
	public A get(String id) {
		PreparedStatement ps = null;
		try {
			Connection cn = DbUtils.getConnection();
			String sql = "select * from a where id = ?";
			logger.info(sql);
			logger.info(id);
			ps = cn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet set = ps.executeQuery();
			A a = null;
			if (set.next()) {
				a = new A();
				a.setId(id);
				a.setAge(set.getInt(2));
			}
			return a;
		} catch (SQLException e) {
			logger.error("数据库操作失败");
			e.printStackTrace();
			throw new RuntimeException("数据库操作失败");
		} finally {
			DbUtils.closePreparedStatement(ps);
		}
	}

	@Override
	public List<A> findList(A a) {
		PreparedStatement ps = null;
		try {
			Connection cn = DbUtils.getConnection();
			StringBuffer sql = new StringBuffer("select * from a where 1 = 1 ");
			if (a.getAge() != null) {
				sql.append("and age = ").append(a.getAge());
			}
			logger.info(sql.toString());
			logger.info(a.toString());
			ps = cn.prepareStatement(sql.toString());
			ResultSet set = ps.executeQuery();
			List<A> list = new ArrayList<>();
			A one = null;
			while (set.next()) {
				one = new A();
				one.setId(set.getString(1));
				one.setAge(set.getInt(2));
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
	public void save(A a) {
		PreparedStatement ps = null;
		try {
			Connection cn = DbUtils.getConnection();
			String sql = "insert into a(id, age) values(?, ?)";
			logger.info(sql);
			logger.info(a.toString());
			ps = cn.prepareStatement(sql);
			ps.setString(1, a.getId());
			ps.setInt(2, a.getAge());
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
	public void update(A a) {
		PreparedStatement ps = null;
		try {
			Connection cn = DbUtils.getConnection();
			StringBuffer sql = new StringBuffer("update a");
			if (a.getAge() != null) {
				sql.append(" set age = ").append(a.getAge());
			}
			sql.append(" where id = ").append(a.getId());
			logger.info(sql.toString());
			logger.info(a.toString());
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
			String sql = "delete from a where id = ?";
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
