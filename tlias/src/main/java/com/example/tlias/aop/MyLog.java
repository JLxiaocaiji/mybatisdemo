package com.example.tlias.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Retention 描述这个注解什么时候有效,RUNTIME 运行时有效
@Target(ElementType.METHOD)   // 指定注解作用目标
public @interface  MyLog {
}

// @annotation 要使用时直接在对应方法上添加 注解 @MyLog
