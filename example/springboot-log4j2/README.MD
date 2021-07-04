## springBoot使用log4j2作为日志组件

TODO

配置文件：

log4j2.xml




## 异步日志


AsyncLogger 


### 全局异步
所有日志都异步的记录，在配置文件上不用做任何改动，只需要添加一个 log4j2.component.properties 配置到 resources；

Log4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector




### 混合异步


