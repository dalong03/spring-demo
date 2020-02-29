package com.fb.webdemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.util.StringUtils;

import com.fb.webdemo.common.exception.BusinessException;

public abstract class PropertiesUtils {

	private static Properties properties = null;

	/**
	 * 读取属性
	 * @param key键
	 * @return 值
	 */
	public static String getProperty(String key) {
		if (properties == null) {
			properties = getProperties();
		} else {
			String devMode = properties.getProperty("devMode");
			if(StringUtils.hasText(devMode) && devMode.equals("true")){
				properties = getProperties();
			}
		}
		String v = properties.getProperty(key);
		if(StringUtils.isEmpty(v)){
			return null;
		}
		String value = null;
		try {
			byte ptext[] = v.getBytes("utf-8");// 将字符串转换成byte类型数组，实质是各个字符的二进制形式
			BigInteger m = new BigInteger(ptext);// 二进制串转换为一个大整数

			byte[] mt = m.toByteArray();// m为密文的BigInteger类型
			value = (new String(mt, "utf-8"));
			value = java.net.URLDecoder.decode(v, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new BusinessException("解码错误");
		}
		return value;
	}

	/**
	 * 读取全部属性
	 * 
	 */
	public static Properties getProperties() {

		// 加载通用属性流
		String file = "properties/application.properties";
		InputStream inStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(file);
				
		// 获取激活的profile，目前只激活一个。未获取激活的profile，则获取默认的profile
		ServletContext context = RequestUtils.getRequest().getServletContext();
		String profile = (String) context.getInitParameter("spring.profiles.active");
		if (StringUtils.isEmpty(profile)) {
			profile = (String) context.getInitParameter("spring.profiles.default");
			throw new BusinessException("未设置默认的profile，未激活profile!");
		}
		// 加载激活的属性流
		String profileProperties = "properties/application-" + profile + ".properties";
		InputStream inStream2 = PropertiesUtils.class.getClassLoader().getResourceAsStream(profileProperties);

		// 读取属性
		Properties properties = new Properties();
		try {
			if (inStream != null) {
				properties.load(inStream);
			}
			if (inStream2 != null) {
				properties.load(inStream2);
			}
		} catch (IOException e) {
			throw new BusinessException("读取属性文件流错误");
		}
		return properties;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		String profile = System.getProperty("spring.profiles.active");
		String env = System.getenv("spring.profiles.active");

		System.out.println(profile);
		System.out.println(env);

	}
}
