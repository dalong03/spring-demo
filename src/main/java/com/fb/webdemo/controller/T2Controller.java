package com.fb.webdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fb.webdemo.common.controller.BaseController;
import com.fb.webdemo.entity.T1;

//@Controller
@RequestMapping("/t2")
public class T2Controller extends BaseController {


	@RequestMapping("")
	public String t1(Model model, HttpServletRequest request, HttpServletResponse response, T1 t1) {
		return "t2";
	}
}
