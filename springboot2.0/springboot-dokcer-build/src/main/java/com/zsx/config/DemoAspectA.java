package com.zsx.config;

import com.zsx.service.DemoService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @date 2022/1/25
 */

@Aspect
@Component
@ConditionalOnProperty(prefix = "demo", name = "service", havingValue = "aaa")
public class DemoAspectA {

    //@Pointcut(value = "@annotation(com.zsx.config.DemoAnno)")
    //@Pointcut("execution(* com.zsx.service.DemoServiceImpl1.*(..))")
    @Pointcut("execution(* com.zsx.service.impl.DemoServiceImpl1.*(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(8899);

        Object proceed = joinPoint.proceed();

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        // 方法名
        String methodName = method.getName();
        System.out.println(methodName);

        // 参数
        Class<? extends Object>[] paramTypes = null;
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            int length = args.length;
            paramTypes = new Class[length];
            for (int i = 0; i < length; i++) {
                paramTypes[i] = args[i].getClass();
                System.out.println(args[i].getClass().getTypeName());
            }
        }


        DemoAnno annotation = method.getAnnotation(DemoAnno.class);
        String annotationValue = annotation.value();
        System.out.println(annotationValue);

        DemoService demoService = null;
        if ("aaa".equals(annotationValue)) {
            demoService = SpringBeanUtils.getBean("DemoServiceBbb", DemoService.class);
        } else if ("bbb".equals(annotationValue)) {
            demoService = SpringBeanUtils.getBean("demoService", DemoService.class);
        }

        if (demoService != null) {


            // 下面这种方式主要解决 参数是基本数据类型的 问题， 不使用上面的参数类型，而是找到所有的方法，匹配方法名和参数个数
            Method[] methods = ReflectionUtils.getAllDeclaredMethods(demoService.getClass());
            //Method[] methods = demoService.getClass().getMethods();
            //Method[] methods = demoService.getClass().getDeclaredMethods();

            Method get = null;

            for (Method method1 : methods) {
            //    System.out.println("demoService 的 方法 " + method1.getName());
            //    Class<?>[] parameterTypes = method1.getParameterTypes();
            //    for (Class<?> parameterType : parameterTypes) {
            //        System.out.println(parameterType.getTypeName());
            //    }
            //
            //    System.out.println(1111);
                String name = method1.getName();
                if (methodName.equals(name)){
                    if (args != null && method1.getParameterTypes() != null && args.length == method1.getParameterTypes().length) {
                        get = method1;
                    }
                }
            }


            // 找到方法
            //Method get = ReflectionUtils.findMethod(demoService.getClass(), methodName, paramTypes);


            //if ("setex".equals(methodName)) {
            //    paramTypes = new Class[]{java.lang.String.class, int.class, String.class};
            //}

            //Method get = demoService.getClass().getMethod(methodName, paramTypes);
            // 执行方法
            ReflectionUtils.invokeMethod(get, demoService, args);
        }


        return proceed;
    }

}
