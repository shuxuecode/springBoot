package com.zsx.config;

import java.lang.annotation.*;

/**
 * @date 2022/1/25
 * @author
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DemoAnno {
    String value() default "aaa";
}
