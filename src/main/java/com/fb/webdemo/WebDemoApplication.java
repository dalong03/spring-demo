package com.fb.webdemo;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class WebDemoApplication {

	public static void main(String[] args) {
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		String[] profiles = context.getEnvironment().getActiveProfiles();
		for (String p : profiles) {
			System.out.println(p);
		}
	}

}