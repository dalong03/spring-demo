package com.fb.webdemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PrimarykeyUtil {
	/**
	 *  生成时间（年月日时分秒毫秒）加5位随机数
	 */
	public static String nextKey(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String date = sdf.format(new Date());
		Random random = new Random();
		String ran = String.valueOf(random.nextInt(89999) + 10000);
		return date + ran ;
	}

}
