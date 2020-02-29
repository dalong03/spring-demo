package com.fb.webdemo.util;

import java.text.DecimalFormat;

public class DecimalUtils {

	/**
	 * 格式化数字
	 * @param number 数字
	 * @param scale 位数
	 * @return
	 */
	public static String format( Number number, int scale){
		StringBuffer buffer=new StringBuffer("#.");
		for(int i=0;i<scale;i++){
			buffer.append("#");
		}
		DecimalFormat format = new DecimalFormat(buffer.toString());
		return format.format(number);
	}
	
}
