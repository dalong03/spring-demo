package com.fb.webdemo.common.exception;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fb.webdemo.util.LogUtils;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		// 保存日志
		LogUtils.saveLog(request, handler, ex, null);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", false);
		if (ex instanceof BusinessException) {
			map.put("errorMsg", ex.getMessage());
		} else {
			map.put("errorMsg", "系统错误");
		}

		String header1=request.getHeader("accept");
		String header2=request.getHeader("X-Requestd-Width");
		if (!(header1 != null && header1.indexOf("application/json") > -1 || header2 != null && header2.indexOf("XMLHttpRequest") > -1)) {
			ex.printStackTrace();
			return new ModelAndView("error", map);
		} else {
			try {
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.write(JSON.toJSONString(map));
				writer.flush();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

	}

}
