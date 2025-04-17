

## 官网  https://mp.baomidou.com/




## 官方示例  https://gitee.com/baomidou/mybatis-plus-samples








## 其它

### MyBatis拦截器

1. 实现 org.apache.ibatis.plugin.Interceptor 接口

```java
public class MybatisInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object result = invocation.proceed();
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        
    }
}
```

2. 在自定义的拦截器上添加需要拦截的对象和方法，通过注解 org.apache.ibatis.plugin.Intercepts 添加

```java
@Component
@Order(1)
@Intercepts({
        @Signature(
                type = StatementHandler.class,
                method = "update",
                args = {Statement.class}
        )
})
```




 