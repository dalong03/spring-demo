package com.fb.webdemo.common.multidatasource.annotation;

import java.lang.annotation.*;

/**
 * 
 * 多数据源标识
 *
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface DataSource {
	String value() default "";

}
