package com.example.springboot.listener;

import com.example.springboot.bean.AsyncInitBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.Ordered;

import java.lang.reflect.Field;

/**
 * @author
 * @date 2022/4/2
 */
public class BeanInitAsyncApplicationListener {

    public static void attach(GenericApplicationContext context) {
        AsyncInitBeanFactory beanFactory = new AsyncInitBeanFactory(context.getBeanFactory(), 8);

        try {
            Field field = GenericApplicationContext.class.getDeclaredField("beanFactory");
            field.setAccessible(true);
            field.set(context, beanFactory);

            context.addApplicationListener(new EnventPublisher(beanFactory));

        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static class EnventPublisher implements ApplicationListener<ContextRefreshedEvent>, Ordered {
        private final AsyncInitBeanFactory asyncInitBeanFactory;

        public EnventPublisher(AsyncInitBeanFactory asyncInitBeanFactory) {
            this.asyncInitBeanFactory = asyncInitBeanFactory;
        }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            if (asyncInitBeanFactory != null) {
                asyncInitBeanFactory.initBean();
            }
        }

        @Override
        public int getOrder() {
            return Ordered.HIGHEST_PRECEDENCE;
        }
    }

}
