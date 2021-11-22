## springBoot集成Docker


## 编写Dockerfile文件

```
FROM openjdk:8-jdk-alpine

ADD target/springboot-docker.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
```

这种严格上说不属于集成docker，只是把打包后的jar，通过Dockerfile添加到容器中了而已。

还有一种docker-maven插件的方式，


[集成docker](../springboot2.0/springboot-dokcer-build/README.MD)


todo
