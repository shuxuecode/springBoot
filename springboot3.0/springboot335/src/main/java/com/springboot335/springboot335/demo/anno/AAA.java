package com.springboot335.springboot335.demo.anno;


import com.springboot335.springboot335.demo.condition.AaaCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Conditional(AaaCondition.class)

@Service
public @interface AAA {
}

