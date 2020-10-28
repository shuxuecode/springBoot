
spring-boot-starter命名的潜规则。

spring-boot-starter-XX是springboot官方的starter

XX-spring-boot-starter是第三方扩展的starter


---

## pom引入

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-autoconfigure</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

## 自动配置

@ConditionalOnClass               当前classpath下有指定类才加载
@ConditionalOnMissingClass        当前classpath下无指定类才加载
@ConditionalOnBean                当期容器内有指定bean才加载
@ConditionalOnMissingBean         当期容器内无指定bean才加载
@ConditionalOnProperty            prefix 前缀name 名称havingValue 用于匹配配置项值matchIfMissing 没找指定配置项时的默认值
@ConditionalOnResource            有指定资源才加载
@ConditionalOnWebApplication      是web才加载
@ConditionalOnNotWebApplication   不是web才加载
@ConditionalOnExpression          符合SpEL 表达式才加载

## 编写properties文件和autoConfiguration文件


## META-INF/spring.factories

META-INF/spring.factories是spring的工厂机制，在这个文件中定义的类，都会被自动加载。多个配置使用逗号分割，换行用\

```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.zsx.redis.RedisAutoConfiguration
```



mvn install 安装到本地仓库

## 使用

### pom引入


```
<dependency>
    <groupId>com.zsx</groupId>
    <artifactId>redis-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### 配置

```
redis.enable=true
redis.host=127.0.0.1
redis.port=6379
```

### 注入使用


```
@Autowired
private RedisCommands<String, String> redisCommands;


void method(){
    redisCommands.set
    redisCommands.get
}

```


---