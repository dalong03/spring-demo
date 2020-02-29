package com.fb.webdemo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.webdemo.common.controller.BaseController;
import com.fb.webdemo.service.ResultService;

@Controller
@RequestMapping("/result")
public class ResultController extends BaseController {

	@Autowired
	private ResultService resultService;

	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(Model model, String items1, String items2, String items3) {
		resultService.save(items1, items2, items3);
		return baseMap;
	}
}
