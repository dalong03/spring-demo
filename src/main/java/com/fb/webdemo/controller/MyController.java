package com.fb.webdemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fb.webdemo.common.controller.BaseController;
import com.fb.webdemo.dao.MyDao;
import com.fb.webdemo.entity.A;
import com.fb.webdemo.entity.User;
import com.fb.webdemo.service.MyService;
import com.fb.webdemo.util.JwtTokenUtil;

/**
 * 代码生成控制器
 */
@Controller
public class MyController extends BaseController {

	@Autowired
	private MyService myService;
	@Autowired
	private MyDao myDao;

	@RequestMapping("/t1")
	public String t1(HttpSession session, Model model, A a) {
		/*A a = myService.get(new A("1"));
		if(a != null){
			System.out.println(a.getName());
		}*/
		/*session.setAttribute("user", new User("1"));
		if(true){
			throw new RuntimeException("==");
		}*/
		
		return "t1";
	}

	@RequestMapping("/t2")
	public String t2(Model model, String a) {
		A aaa = new A();
		aaa.setId("1");
		aaa.setName("tom");
		List<A> list = myService.findList(aaa);
		model.addAttribute("list", list);
		
		A a2 = myService.get("1");
		model.addAttribute("a2", a2);
		
		return "t2";
	}

	@RequestMapping(value="t3")
	public String t3(Model model,HttpServletRequest request, HttpServletResponse response, String a) throws IOException {
		//前端传过来的回调函数名称
	    String callback = request.getParameter("callback");
	    //用回调函数名称包裹返回数据，这样，返回数据就作为回调函数的参数传回去了
	    String result = callback + "(" + 1 + ")";

	    response.getWriter().write(result);
		return "t3";
	}
	
	@RequestMapping(value="t4")
	@ResponseBody
	public Map<String, Object> t4(Model model, A a, HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("Authorization");
		String uId = JwtTokenUtil.getUsernameFromToken(token);
		System.out.println(uId);
		System.out.println(token);
		return baseMap;
	}
	
	@RequestMapping(value="t5")
	public void t5(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		//前端传过来的回调函数名称
	    String callback = request.getParameter("callback");
	    //用回调函数名称包裹返回数据，这样，返回数据就作为回调函数的参数传回去了
	    String result = callback + "(1)";
	    PrintWriter out = response.getWriter();
	    out.write(result);
	    out.flush();
		out.close();
	}
	
}
