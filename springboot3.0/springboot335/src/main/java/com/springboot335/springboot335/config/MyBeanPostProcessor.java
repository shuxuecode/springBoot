package com.springboot335.springboot335.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * BeanPostProcessor
 * <p>
 * 工厂钩子，允许自定义修改新的bean实例，例如检查标记接口或用代理包装bean。
 * 实现了bean的后处理器将会将调用postProcessBeforeInitialization方法，和postProcessAfterInitialization。
 */

@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        //System.out.println("postProcessBeforeInitialization beanName:" + beanName);
        //System.out.println(bean.getClass().getName());

        if (!bean.getClass().getName().equals("com.springboot335.springboot335.demo.DemoService")) {
            return bean;
        }

        Method[] declaredMethods = bean.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            try {
                System.out.println("declaredMethod = " + declaredMethod);
                Object invoke = declaredMethod.invoke(bean, null);

                System.out.println("invoke = " + invoke);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        //System.out.println("postProcessAfterInitialization beanName:" + beanName);

        if ("demoService".equals(beanName)) {

            // 使用CGLIB代理，修改指定方法的返回值

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback(new MethodInterceptor() {

                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    // 调用原始方法
                    Object result = proxy.invokeSuper(obj, args);

                    // 修改指定方法的返回值
                    if ("testGet".equals(method.getName())) {
                        return "postProcessAfterInitialization testGet";
                    }

                    return result;
                }
            });

            return enhancer.create();
        }

        return bean;
    }
}
