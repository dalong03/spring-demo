package com.fb.webdemo.common.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fb.webdemo.entity.User;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		String path = request.getServletPath();
		if(path.equals("/login") || path.equals("/user/toIndex") || path.equals("/reLogin")){
			return true;
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user != null){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", false);
			map.put("errorMsg", "您已掉线，请重新登录");
			String header1=request.getHeader("accept");
			String header2=request.getHeader("X-Requestd-Width");
			if (!(header1 != null && header1.indexOf("application/json") > -1 || header2 != null && header2.indexOf("XMLHttpRequest") > -1)) {
				response.sendRedirect("/FoodSupervise/reLogin");
				return false;
			} else {
				try {
					response.setContentType("application/json;charset=UTF-8");
					PrintWriter writer = response.getWriter();
					writer.write(JSON.toJSONString(map));
					writer.flush();
					writer.close();
					return false;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception {
		System.out.println("===");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) throws Exception {
	}


}
