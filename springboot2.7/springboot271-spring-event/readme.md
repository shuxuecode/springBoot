todo

## Spring事件

可以作为异步处理



## 发布事件

```JAVA
@Autowired
private ApplicationEventPublisher applicationEventPublisher;

applicationEventPublisher.publishEvent(eventObject);
```

## 


## 异步模式

```JAVA
@Configuration
public class EventConfig {

    @Bean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
    public SimpleApplicationEventMulticaster myEventMulticaster(){
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(taskExecutor());
        return simpleApplicationEventMulticaster;
    }
    
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(300);
        executor.setThreadNamePrefix("thread-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
```

注入一个simpleApplicationEventMulticaster。将这个multicaster的taskexecutor设置为自定义的线程池。
当publish event时，当前线程会到从线程池里来取线程，进行invoke listener，以及执行subscriber逻辑。

名字必须是applicationEventMulticaster，因为AbstractApplicationContext默认找个


