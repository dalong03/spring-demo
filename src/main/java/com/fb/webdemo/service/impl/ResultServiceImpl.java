package com.fb.webdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.fb.webdemo.common.service.CrudServiceImpl;
import com.fb.webdemo.dao.DetailsDao;
import com.fb.webdemo.dao.ResultDao;
import com.fb.webdemo.entity.Details;
import com.fb.webdemo.entity.Result;
import com.fb.webdemo.service.ResultService;
import com.fb.webdemo.util.UuidUtils;

@Service
public class ResultServiceImpl extends CrudServiceImpl<ResultDao, Result> implements ResultService {

	@Autowired
	private ResultDao resultDao;
	@Autowired
	private DetailsDao detailsDao;

	@Override
	@Transactional
	public int save(String items1, String items2, String items3) {
		String resultId = UuidUtils.getUuid();
		List<Details> detailsList = new ArrayList<Details>();
		List<Details> details1List = JSON.parseArray(items1, Details.class);
		for (Details d : details1List) {
			d.setId(UuidUtils.getUuid());
			d.setResultId(resultId);
			detailsList.add(d);
		}

		List<Details> details2List = JSON.parseArray(items2, Details.class);
		for (Details d : details2List) {
			d.setId(UuidUtils.getUuid());
			d.setResultId(resultId);
			detailsList.add(d);
		}

		List<Details> details3List = JSON.parseArray(items3, Details.class);
		for (Details d : details3List) {
			d.setId(UuidUtils.getUuid());
			d.setResultId(resultId);
			detailsList.add(d);
		}
		int a = detailsDao.batchSave(detailsList);
		if (a == 0) {
			throw new RuntimeException("系统异常");
		}

		Result result = new Result();
		result.setId(resultId);
		result.setItem1Count(details1List.size());
		result.setItem2Count(details2List.size());
		result.setItem3Count(details3List.size());
		int b = resultDao.save(result);
		if (b == 0) {
			throw new RuntimeException("系统异常");
		}
		return 0;
	}

}
