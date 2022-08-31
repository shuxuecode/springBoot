package com.zsx.springbootmybatisplus.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.Properties;

/**
 * 拦截器
 * <p>
 * 1、实现 org.apache.ibatis.plugin.Interceptor 接口
 * 2、在自定义的拦截器上添加需要拦截的对象和方法，通过注解 org.apache.ibatis.plugin.Intercepts 添加
 *
 * @date 2022/8/30
 */
@Component
@Order(1)
@Intercepts({
        @Signature(
                type = StatementHandler.class,
                method = "update",
                args = {Statement.class}
        )
})
public class MybatisInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        invocation.getArgs();
        invocation.getMethod();
        invocation.getTarget();

        Object result = invocation.proceed();

        result = result;

        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties);
    }
}
