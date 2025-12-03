package com.springboot335.springboot335.aop;

import com.springboot335.springboot335.demo.anno.Demo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@Configuration
@Aspect
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy(exposeProxy = true) // 启用 exposeProxy 并正确使用 AopContext.currentProxy()
/*
如果不加 exposeProxy = true，则无法使用 AopContext.currentProxy()
报错：
java.lang.IllegalStateException: Cannot find current proxy: Set 'exposeProxy' property on Advised to 'true' to make it available, and ensure that AopContext.currentProxy() is invoked in the same thread as the AOP invocation context.
 */
public class DemoAnnoAop {

    private final SpelExpressionParser spelExpressionParser = new SpelExpressionParser();


    @Pointcut("@annotation(demo)")
    public void pointcut(Demo demo) {

    }

    @Before(value = "pointcut(demo)", argNames = "joinPoint,demo")
    public void doBefore(JoinPoint joinPoint, Demo demo) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("before");

        String key = demo.key();

        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();

        StandardEvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }

        String value = spelExpressionParser.parseExpression(key).getValue(context, String.class);
        System.out.println("value : " + value);

    }

    @After(value = "pointcut(demo)", argNames = "joinPoint,demo")
    public void doAfter(JoinPoint joinPoint, Demo demo) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String key = demo.key();
        System.out.println("after");
        System.out.println(key);
    }

}
