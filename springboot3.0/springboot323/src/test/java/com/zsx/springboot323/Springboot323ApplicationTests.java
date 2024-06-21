package com.zsx.springboot323;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.util.Arrays;

@SpringBootTest
class Springboot323ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello world");
    }


    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        System.out.println(8899);
        System.out.println(8899);
        System.out.println(8899);

        Arrays.sort(beanDefinitionNames);
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(8899);
        System.out.println(8899);
        System.out.println(8899);
    }

    @Test
    public void t2() {

        ComponentScan componentScan = AnnotatedElementUtils.findMergedAnnotation(applicationContext.getClass(), ComponentScan.class);
        if (componentScan != null) {
            String[] basePackages = componentScan.basePackages();
            for (String basePackage : basePackages) {
                System.out.println("basePackage : " + basePackage);
            }

            Class<?>[] basePackageClasses = componentScan.basePackageClasses();
            for (Class<?> basePackageClass : basePackageClasses) {
                System.out.println("basePackageClass: " + basePackageClass);
            }
        }

    }
}
