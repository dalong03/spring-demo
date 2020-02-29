package com.fb.webdemo.util;

import javax.servlet.http.HttpSession;

public class SessionUtils {
	public static HttpSession getSession(){
		return RequestUtils.getRequest().getSession();
	}
}
