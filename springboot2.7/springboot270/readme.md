## 利用.env文件隐藏配置信息

> .env 文件一般用于存储项目的环境变量，一般像云服务密码、数据库 ip 等信息都可以在 .env 文件中存放，而不是明文放置于项目的配置文件中（例如 application.yml）。

### 创建.env文件

.env 文件以 K-V 形式存储数据，文件格式形同 *.properties，建议将 Key 进行大写操作：
```properties
USERNAME=username
PASSWORD=password
```

### SpringBoot引入外部配置文件

```yaml
spring:
  config:
    import: optional:classpath:/.env[.properties]


test:
  username: ${USERNAME}
  password: ${PASSWORD}

```

