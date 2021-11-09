


## 引入相关jar

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

> 注意：新版的spring-boot-starter-web包里面已经不包含hibernate-validator包了


## hibernate的校验模式

### 普通模式（默认是这个模式）
普通模式(会校验完所有的属性，然后返回所有的验证失败信息)

### 快速失败返回模式
快速失败返回模式(只要有一个验证失败，则返回)


