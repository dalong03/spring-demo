package demo;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.fb.webdemo.controller.T1Controller;
import com.fb.webdemo.service.T1Service;

public class BeanFactoryTest {

	@SuppressWarnings({ "deprecation", "unused" })
	@Test
	public void test1() {
		ClassPathResource resource = new ClassPathResource("applicationContext2.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		T1Controller t1Controller = (T1Controller) factory.getBean("t1Controller");
		T1Service t1Service = (T1Service) factory.getBean("t1Service");
		System.out.println(t1Controller);
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test2() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		T1Controller t1Controller = (T1Controller) ctx.getBean("t1Controller");
		System.out.println(t1Controller.getT1Service());
	}
}
