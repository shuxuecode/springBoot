# SpringBoot多数据源配置

## 主要思路

### 1、配置两个数据源


```yaml
#第一个数据源
spring.datasource.druid.one.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true
spring.datasource.druid.one.username=root
spring.datasource.druid.one.password=root
spring.datasource.druid.one.driver-class-name=com.mysql.jdbc.Driver
#第二个数据源
spring.datasource.druid.two.url=jdbc:mysql://localhost:3306/mytest?characterEncoding=utf8&useSSL=true
spring.datasource.druid.two.username=root
spring.datasource.druid.two.password=root
spring.datasource.druid.two.driver-class-name=com.mysql.jdbc.Driver
```

### 数据源注册

见类  `DynamicDataSourceRegister`


todo




















































































































































---
