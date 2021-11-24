// todo zsx

# 修改springboot配置文件加载路径

**主要为了配置文件中有敏感数据时，可以把配置文件放到服务器的其它位置，这样项目可以随便编译打包部署，从而避免了配置文件被泄露的风险**

## 默认配置

配置类  ConfigFileApplicationListener

- 配置文件路径key 是 "spring.config.location"
- 配置文件路径value 默认是 "classpath:/,classpath:/config/,file:./,file:./config/"
  - springboot会根据上面的顺序依次加载配置文件，所以如果配置文件都存在，则后面的会覆盖前面加载的（因为数据存的结构是Set），即`./config/`的优先级最高
- 配置文件名称key 是 "spring.config.name"


> 在properties和yml/yaml配置文件同时存在的情况下, 在同一目录下，properties配置优先级 > YAML(YML)配置优先级


## 修改配置文件路径

```java
new SpringApplicationBuilder(App.class)
    .properties("spring.config.location:/root/user/config/")
    .build().run(args);
```


