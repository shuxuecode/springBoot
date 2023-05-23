package com.zsx.springboot2711.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @date 2023/5/22
 */

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LogAspect {


    @Pointcut("@annotation(com.zsx.springboot2711.aop.annotation.PrintLog)")
    public void pointCut() {
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("8899");

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        Object resultObj = joinPoint.proceed();

        return resultObj;
    }

}
