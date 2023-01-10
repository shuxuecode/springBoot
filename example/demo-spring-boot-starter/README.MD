## 配置springboot starter示例

### 命名规范：

Srping 官方命名格式为：spring-boot-starter-{name}

非 Spring 官方建议命名格式：{name}-spring-boot-starter


## pom依赖

```xml
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

spring-boot-autoconfigure : 提供自动化装配功能，是为了 Spring Boot 应用在各个模块提供自动化配置的作用；即加入对应 pom，就会有对应配置其作用；所以我们想要自动装配功能，就需要引入这个依赖。

spring-boot-configuration-processor：将自定义的配置类生成配置元数据，所以在引用自定义 STARTER 的工程的 YML 文件中，给自定义配置初始化时，会有属性名的提示；确保在使用 @ConfigurationProperties 注解时，可以优雅的读取配置信息，引入该依赖后，IDEA 不会出现 “spring boot configuration annotation processor not configured” 的错误；编译之后会在 META-INF 下生成一个 spring-configuration-metadata.json 文件，大概内容就是定义的配置的元数据







TODO