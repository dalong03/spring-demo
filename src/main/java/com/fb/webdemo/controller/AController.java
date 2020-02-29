package com.fb.webdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fb.webdemo.jdbc.dao.ADao;
import com.fb.webdemo.jdbc.entity.A;
import com.fb.webdemo.jdbc.service.AService;

@RestController
@RequestMapping("/a")
public class AController {

	@Autowired
	private AService aService;
	@Autowired
	private ADao aDao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public A get(HttpServletRequest req, @PathVariable("id") String id) {
		return aDao.get(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<A> findList(HttpServletRequest req, @RequestBody A a) {
		return aDao.findList(a);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public A save(HttpServletRequest req, @RequestBody A a) {
		aDao.save(a);
		return a;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public A update(HttpServletRequest req, @RequestBody A a) {
		aDao.update(a);
		return a;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(HttpServletRequest req, @PathVariable("id") String id) {
		aDao.delete(id);
		return id;
	}
}
