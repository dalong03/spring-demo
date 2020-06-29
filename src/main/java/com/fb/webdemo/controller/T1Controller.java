package com.fb.webdemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.webdemo.common.controller.BaseController;
import com.fb.webdemo.dao.T1Dao;
import com.fb.webdemo.entity.T1;
import com.fb.webdemo.service.T1Service;
import com.fb.webdemo.util.JwtTokenUtil;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/t1")
public class T1Controller extends BaseController {

	@Autowired
	private T1Service t1Service;
	@Autowired
	private T1Dao t1Dao;

	@RequestMapping("/1")
	public String t1(Model model, HttpServletRequest request, HttpServletResponse response, T1 t1) {
		
		return "t1";
	}

	@RequestMapping("/2")
	public String t2(Model model, String t1) {
		return "t2";
	}

	@RequestMapping(value="/3")
	public String t3(Model model,HttpServletRequest request, HttpServletResponse response, String t1) throws IOException {
		//前端传过来的回调函数名称
	    String callback = request.getParameter("callback");
	    //用回调函数名称包裹返回数据，这样，返回数据就作为回调函数的参数传回去了
	    String result = callback + "(" + 1 + ")";

	    response.getWriter().write(result);
		return "t3";
	}
	
	@RequestMapping(value="/4")
	@ResponseBody
	public Map<String, Object> t4(Model model, T1 t1, HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("Authorization");
		String uId = JwtTokenUtil.getUsernameFromToken(token);
		System.out.println(uId);
		System.out.println(token);
		return baseMap;
	}
	
	@RequestMapping(value="/5")
	public void t5(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		//前端传过来的回调函数名称
	    String callback = request.getParameter("callback");
	    //用回调函数名称包裹返回数据，这样，返回数据就作为回调函数的参数传回去了
	    String result = callback + "({\n" + 
	    		"    \"code\": \"CA1998\",\n" + 
	    		"    \"price\": 1780,\n" + 
	    		"    \"tickets\": 50\n" + 
	    		"})";
	    PrintWriter out = response.getWriter();
	    out.write(result);
	    out.flush();
		out.close();
	}
	
	@RequestMapping(value="")
	@ResponseBody
	public PageInfo<T1> findPage(Model model,HttpServletRequest request, HttpServletResponse response, T1 t1, PageInfo<T1> pageInfo) throws IOException {
		return t1Service.findPage(t1, pageInfo);
	}
	
	
}
