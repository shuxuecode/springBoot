package com.springboot335.springboot335.demo.anno;

import com.springboot335.springboot335.demo.condition.BbbCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Conditional(BbbCondition.class)
public @interface BBB {
}
