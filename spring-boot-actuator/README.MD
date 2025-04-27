todo

```XML
        <!-- 只需引入spring-boot-devtools 即可实现热部署 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>
```



Spring Boot Actuator 是一个非常有用的工具，可以帮助开发者监控和管理 Spring Boot 应用程序。以下是关于如何在项目中启用并使用 Spring Boot Actuator 的基本指南。

```XML
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

默认情况下，Actuator 端点是禁用的。你需要在 application.properties 或 application.yml 中启用它们。

management.endpoints.web.exposure.include=*


这会暴露所有可用的 Actuator 端点。你可以选择性地指定哪些端点被暴露出来，

management.endpoints.web.exposure.include=health,info

一旦启用了 Actuator 端点，就可以通过 HTTP 请求来访问这些端点了。通常，这些端点位于 /actuator 路径下

Health - 检查应用健康状态：

GET /actuator/health



