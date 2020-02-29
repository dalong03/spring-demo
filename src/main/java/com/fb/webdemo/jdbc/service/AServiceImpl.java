package com.fb.webdemo.jdbc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.webdemo.jdbc.dao.ADao;
import com.fb.webdemo.util.DbUtils;

@Service
public class AServiceImpl implements AService {
	private static final Logger logger = LoggerFactory.getLogger(DbUtils.class);

	@Autowired
	private ADao aDao;

}
