todo




## 多个aop切面拦截配置




## spring扫描时排除指定的包路径

```java
@ComponentScan(
        basePackages = "com.example.project",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX, 
                pattern = "com.example.project.exclude.*"
        )
)
```

## spring扫描时排除指定的类

```java
@ComponentScan(
        basePackages = {
                "com.zsx.springboot320",
                "org.z.s.x.springboot"
        },
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        value = {ErrorTestConfig.class})
        }
)
```



