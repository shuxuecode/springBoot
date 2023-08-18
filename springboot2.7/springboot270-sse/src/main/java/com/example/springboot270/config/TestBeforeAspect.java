package com.example.springboot270.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @date 2023/8/14
 */
// @Component
// @Aspect
public class TestBeforeAspect {


    @Pointcut("@annotation(com.example.springboot270.config.anno.TestAnno)")
    public void pointCut() {
    }


    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
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
//         try {
//             RequestLimit annotation = method.getAnnotation(RequestLimit.class);
//             if (annotation != null) {
//                 if (annotation.enabled()) {
//
//                     int duration = annotation.duration();
//
//                     // todo zsx
//                     // todo zsx
//                     // todo zsx
//
//                     Object[] args = joinPoint.getArgs();
//                     BaseRequest baseRequest = null;
//                     for (Object arg : args) {
//                         if (arg instanceof BaseRequest) {
//                             baseRequest = (BaseRequest) arg;
//                         }
//                     }
//                     if (baseRequest != null) {
//                     }
//
//                 }
//             }
//         } catch (Exception e) {
//         }
//
//
    }

}
