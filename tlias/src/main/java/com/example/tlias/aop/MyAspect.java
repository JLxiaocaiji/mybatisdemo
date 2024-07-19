package com.example.tlias.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MyAspect {
    // 定义切入点 可直接使用函数 pt
    // 在其他文件，函数中也能使用, 例如在 TimeAspect 中也能使用 "pt"， 需要在定义时将 private 改成 public
    @Pointcut("execution(* com.example.tlias.service.impl.DeptServiceImpl.*(..) *))")

    // Pointcut 匹配表达式
    @Pointcut("execution(* com.example.tlias.service.DeptService.list()) ||" +
        "excution(* com.example.tlias.service.DeptService.delete(java.lang.Integer)")
    public void pt(){}

    @Pointcut("@annotation(com.example.tlias.aop.MyLog)")
    @Before("pt")
    public void before() {
        log.info("before ...");
    }

    @Around("pt")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("around before ...");

        // 调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();

        log.info("around after ...");
        return result;
    }

    @After("execution(* com.example.tlias.service.impl.DeptServiceImpl.*(..) *))")
    public void after() {
        log.info("after ...");
    }

    @AfterReturning("execution(* com.example.tlias.service.impl.DeptServiceImpl.*(..) *))")
    public void afterReturning() {
        log.info("afterReturning");
    }

    @AfterThrowing("execution(* com.example.tlias.service.impl.DeptServiceImpl.*(..) *))")
    public void afterThrowing() {
        log.info("afterThrowing ...");
    }


    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("MyAspect ... before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throw Throwable {
        log.info("MyAspect around before ...");

        // 1.获取目标对象的类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("目标对象的类名", className);

        // 2.获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("目标对象方法名", methodName);

        // 3.获取目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法运行时传入的参数：{}", Arrays.toString(args));

        // 4.放行 目标方法执行
        Object result = joinPoint.proceed();

        // 5. 获取 目标方法运行的返回值
        log.info("11",result);

        return null;
    }
}
