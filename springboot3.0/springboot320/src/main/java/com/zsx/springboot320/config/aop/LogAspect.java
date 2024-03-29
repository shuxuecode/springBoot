package com.zsx.springboot320.config.aop;

import com.alibaba.fastjson.JSONObject;
import com.zsx.springboot320.dto.RequestDTO;
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
public class LogAspect {


    //@Pointcut("execution(* com.zsx.springboot320..*(..))")
    @Pointcut("@annotation(com.zsx.springboot320.config.anno.MyLog)")
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

                if (arg instanceof RequestDTO requestDTO) {
                    System.out.println(requestDTO.getName());
                }

                JSONObject jsonObject = JSONObject.parseObject(arg.toString());
                System.out.println(jsonObject.toJSONString());

            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Object result = joinPoint.proceed();
        System.out.println("after");
        return result;
    }


}
