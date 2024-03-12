package com.zsx.springboot323.config.anno;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author zsx
 * @date 2024/3/12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomBean {

    String value() default "";

}
