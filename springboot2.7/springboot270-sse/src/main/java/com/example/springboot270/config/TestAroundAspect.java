package com.example.springboot270.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @date 2023/8/14
 */
@Component
@Aspect
public class TestAroundAspect {


    @Pointcut("@annotation(com.example.springboot270.config.anno.TestAnno)")
    public void pointCut() {
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();


        Object[] args = joinPoint.getArgs();
        System.out.println("打印参数");
        System.out.println(args.length);
        Arrays.stream(args).forEach(System.out::println);

        for (Object arg : args) {
            String jsonString = JSON.toJSONString(arg);
            Object obj = JSONPath.extract(jsonString, "$.id");
            System.out.println(obj);

            System.out.println(JSONPath.extract(jsonString, "$.name"));
        }

        //
        // return joinPoint.proceed();
        // 测试返回其它类型数据
        // return new Date();  // java.lang.ClassCastException: java.util.Date cannot be cast to java.lang.String
        return "123";
    }

}
