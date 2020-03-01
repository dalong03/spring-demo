package com.fb.webdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fb.webdemo.dao.BDao;
import com.fb.webdemo.entity.B;

@RestController
@RequestMapping("/b")
public class BController {

	@Autowired
	private BDao bDao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public B get(HttpServletRequest req, @PathVariable("id") String id) {
//		if(true) {
//			throw new RuntimeException("==");
//		}
		return bDao.get(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<B> findList(HttpServletRequest req, Integer age) {
		B a = new B();
		a.setAge(age);
		return bDao.findList(a);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public B save(HttpServletRequest req, @RequestBody B a) {
		bDao.save(a);
		return a;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public B update(HttpServletRequest req, @RequestBody B a) {
		bDao.update(a);
		return a;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(HttpServletRequest req, @PathVariable("id") String id) {
		bDao.delete(id);
		return id;
	}
}
