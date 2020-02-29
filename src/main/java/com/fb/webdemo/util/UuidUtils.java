package com.fb.webdemo.util;

import java.util.UUID;

public class UuidUtils {

	public static String getUuid() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(getUuid());
		
	}
}
