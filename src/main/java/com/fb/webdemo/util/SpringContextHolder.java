package com.fb.webdemo.util;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringContextHolder implements ApplicationContextAware,DisposableBean{
	private static ApplicationContext applicationContext = null;
	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

	/**
	 * 注入spring context
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
		
	}
	
	/**
	 * 获取 spring context
	 * @return
	 */
	public ApplicationContext getApplicationContext(){
		assertContextInject();
		return applicationContext;
	}
	
	/**
	 * 获取 bean
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name){
		assertContextInject();
		return (T)applicationContext.getBean(name);
	}
	
	/**
	 * 获取 bean
	 */
	public static <T> T getBean(Class<T> clazz){
		assertContextInject();
		return (T)applicationContext.getBean(clazz);
	}

	/**
	 * spring context关闭时，清理静态变量
	 */
	@Override
	public void destroy() throws Exception {
		if (logger.isDebugEnabled()){
			logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
		}
		applicationContext = null;
	}
	
	/**
	 * 检查spring context不为空
	 */
	public static void assertContextInject(){
		Validate.validState(applicationContext != null, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
	}
}
