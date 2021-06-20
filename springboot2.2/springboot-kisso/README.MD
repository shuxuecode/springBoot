


## Dropwizard-Metrics统计连接池使用情况

1. pom.xml加上Dropwizard-Metrics配置

```
<dependency>
    <groupId>io.dropwizard.metrics</groupId>  
    <artifactId>metrics-core</artifactId>  
</dependency>  
<dependency>  
    <groupId>io.dropwizard.metrics</groupId>  
    <artifactId>metrics-healthchecks</artifactId>  
</dependency>  
```

2. 在应用启动的时候连接池注册统计接口

```
@Autowired    
private DataSource dataSource;   

@Override    
public void run(ApplicationArguments args) throws Exception {    
    try {    
        // see detail https://github.com/brettwooldridge/HikariCP/wiki/Dropwizard-Metrics    
        // 连接池注册统计接口    
        MetricRegistry metricRegistry = new MetricRegistry();    
        if(dataSource instanceof HikariDataSource) {    
            ((HikariDataSource) dataSource).setMetricRegistry(metricRegistry);    
        }    
        // 定时打印连接池使用情况    
        Slf4jReporter reporter = Slf4jReporter.forRegistry(metricRegistry).build();    
        reporter.start(1, TimeUnit.MINUTES);    

    } catch (Exception e) {    
        String msg = "服务启动异常";    
        LOGGER.error(msg, e);    
        throw new IllegalStateException(msg, e);    
    }     
}   
```

