package com.zsx.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class AopAspect {


    @Pointcut("execution(* com.zsx.test..*.*(..))")
    public void pointCut2() {
    }

    @Around("pointCut2()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}
