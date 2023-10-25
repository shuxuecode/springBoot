// todo zsx


测试 bean的加载和初始化

##

### 声明一个bean类，实现InitializingBean

```java
public class TestBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        //code here
    }
    
}
```

### 在另一个配置类中，声明并加载该bean

```java
@Configuration
public class TestBeanConfig {


    @Bean(name = "testBean2")
    public TestBean init() {
        return new TestBean();
    }
}
```

### 按正常的bean使用即可