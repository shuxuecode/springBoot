package com.example.springboot.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author
 * @date 2022/4/6
 */
public class AsyncInitBeanFactory extends DefaultListableBeanFactory {

    private final static List<Future> FUTURES = new ArrayList<>();

    private final ThreadPoolExecutor threadPool;

    public AsyncInitBeanFactory(BeanFactory parentBeanFactory, int poolSize) {
        super(parentBeanFactory);

        this.threadPool = new ThreadPoolExecutor(poolSize, poolSize, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }

    private List<String> asyncBeanList = new ArrayList<>();

    @Override
    protected void invokeInitMethods(String beanName, Object bean, RootBeanDefinition mbd) throws Throwable {
        asyncBeanList.add("userServiceImpl");

        if (!asyncBeanList.contains(beanName) || bean instanceof FactoryBean) {
            super.invokeInitMethods(beanName, bean, mbd);
        } else {
            FUTURES.add(threadPool.submit(() -> {
                try {
                    AsyncInitBeanFactory.super.invokeInitMethods(beanName, bean, mbd);
                } catch (Throwable e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }));
        }
    }

    public void initBean() {
        for (Future future : FUTURES) {
            try {
                future.get();
                //future.get(5L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                shutdown();
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                e.printStackTrace();
                shutdown();
                throw new RuntimeException(e);
            //} catch (TimeoutException e) {
            //    e.printStackTrace();
            //    shutdown();
            //    throw new RuntimeException(e);
            }
        }
    }

    private void shutdown() {
        if (threadPool != null) {
            threadPool.shutdown();
        }
    }

}
