package com.example.tlias.aop;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component  // 将当前类交给 ioc 容器管理
@Aspect     // aop 类
public class TimeAspect {

    @Around("execution(* com.example.service.*.*(..) *)")   // 切入点 及 作用服务对象 表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录开始时间
        long begin = System.currentTimeMillis();

        // 调用原始方法运行
        Object result =  joinPoint.procced();

        // 记录
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法执行耗时: {}ms", end-begin);

        return result;
    }
}
