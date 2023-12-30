package com.zsx.test.bean.aaa;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Anno {
}
