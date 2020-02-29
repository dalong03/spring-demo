package com.fb.webdemo.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	protected static Map<String, Object> baseMap = new HashMap<String, Object>();
	static {
		baseMap.put("success", true);
	}
}
