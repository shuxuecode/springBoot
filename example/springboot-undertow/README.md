# Undertow


Undertow 是红帽公司开发的一款基于 NIO 的高性能 Web 嵌入式服务器


## Untertow 的特点：


- 轻量级：它是一个 Web 服务器，但不像传统的 Web 服务器有容器概念，它由两个核心 Jar 包组成，加载一个 Web 应用可以小于 10MB 内存

- Servlet3.1 支持：它提供了对 Servlet3.1 的支持


- WebSocket 支持：对 Web Socket 完全支持，用以满足 Web 应用巨大数量的客户端

- 
嵌套性：它不需要容器，只需通过 API 即可快速搭建 Web 服务器


---

## 因为springboot默认的嵌入式容器是Tomcat，所以需要修改为undertow

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <!-- Exclude the Tomcat dependency -->
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<!-- Use Undertow instead -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-undertow</artifactId>
</dependency>
```





## 打成jar包后怎么运行

- 1

```
nohup java -jar test.jar >temp.txt &
```

> 这种方法会把日志文件输入到你指定的文件中，没有则会自动创建。进程会在后台运行。

- 2

```
nohup command > command.log 2>&1& echo $! > command.pid
```

> 获取pid


```
# 停止命令

kill `cat command.pid`
```

- 3

```
nohup java -jar -Xms128M -Xmx1024M -server.port=9002 XX.jar > XX.out 2>&1 &
```
-Xms128M -Xmx1024M：指定内存，Xms一般为最大内存的1/64,Xmx一般为最大内存的1/4
-server.port=9002：指定端口



---

附：Shell中的特殊变量说明

变量	说明
$$	Shell本身的PID（ProcessID）
$!	Shell最后运行的后台Process的PID
$?	最后运行的命令的结束代码（返回值）
$-	使用Set命令设定的Flag一览
$*	所有参数列表。如"$*"用「"」括起来的情况、以"$1 $2 … $n"的形式输出所有参数。
$@	所有参数列表。如"$@"用「"」括起来的情况、以"$1" "$2" … "$n" 的形式输出所有参数。
$#	添加到Shell的参数个数
$0	Shell本身的文件名
$1～$n	添加到Shell的各参数值。$1是第1参数、$2是第2参数…。