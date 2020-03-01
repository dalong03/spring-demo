package com.fb.webdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fb.webdemo.dao.CDao;
import com.fb.webdemo.entity.C;
import com.fb.webdemo.service.CService;

@RestController
@RequestMapping("/c")
public class CController {

	@Autowired
	private CService cService;
	@Autowired
	private CDao cDao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public C get(HttpServletRequest req, @PathVariable("id") String id) {
//		if(true) {
//			throw new RuntimeException("==");
//		}
		return cService.get(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<C> findList(HttpServletRequest req, Integer age) {
		C a = new C();
		a.setAge(age);
		return cService.findList(a);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public C save(HttpServletRequest req, @RequestBody C a) {
		cService.save(a);
		return a;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public C update(HttpServletRequest req, @RequestBody C a) {
		cService.update(a);
		return a;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(HttpServletRequest req, @PathVariable("id") String id) {
		cService.delete(id);
		return id;
	}
}
