## 常用命令


### (1)列出所有的数据库
- mysql: show databases
- psql: \l或\list

### (2)切换数据库
- mysql: use dbname
- psql: \c dbname

### (3)列出当前数据库下的数据表
- mysql: show tables
- psql: \d

### (4)列出指定表的所有字段
- mysql: show columns from table name
- psql: \d tablename

### (5)查看指定表的基本情况
- mysql: describe tablename
- psql: \d+ tablename

### (6)退出登录
- mysql: quit 或者\q
- psql:\q




<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>


spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.driver-class-name=org.postgresql.Driver


spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

