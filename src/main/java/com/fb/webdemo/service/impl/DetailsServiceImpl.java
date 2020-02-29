package com.fb.webdemo.service.impl;

import org.springframework.stereotype.Service;

import com.fb.webdemo.common.service.CrudServiceImpl;
import com.fb.webdemo.dao.DetailsDao;
import com.fb.webdemo.entity.Details;
import com.fb.webdemo.service.DetailsService;

@Service
public class DetailsServiceImpl extends CrudServiceImpl<DetailsDao, Details> implements DetailsService {


}
