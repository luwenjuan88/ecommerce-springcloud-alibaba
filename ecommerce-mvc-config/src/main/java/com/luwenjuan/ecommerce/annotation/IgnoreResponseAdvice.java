package com.luwenjuan.ecommerce.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>标识接口不返回统一响应</h1>
 *
 * 元注解标识-注解作用的位置：Java类，Java方法
 * 元注解标识-当前的注解需要被保留到什么时候：运行时
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {

}
