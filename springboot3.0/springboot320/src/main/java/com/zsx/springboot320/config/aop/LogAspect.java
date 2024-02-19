package com.zsx.springboot320.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @date 2024/2/19
 */
@Aspect
public class LogAspect {



    @Pointcut("execution(* com.zsx.springboot320..*(..))")
    public void point() {}


    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before");
        Object result = joinPoint.proceed();
        System.out.println("after");
        return result;
    }



}
