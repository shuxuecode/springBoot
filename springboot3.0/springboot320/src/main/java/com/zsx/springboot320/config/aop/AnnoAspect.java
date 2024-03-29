package com.zsx.springboot320.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @date 2024/2/19
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnnoAspect {


    //@Pointcut("execution(* com.zsx.springboot320..*(..))")
    @Pointcut("@annotation(com.zsx.springboot320.config.anno.MyAnno)")
    public void point() {
    }


    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before");

        try {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {

                System.out.println("class = " + arg.getClass().getName());
                System.out.println("className = " + arg.getClass().getSimpleName());

            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Object result = joinPoint.proceed();
        System.out.println("after");
        return result;
    }


}
