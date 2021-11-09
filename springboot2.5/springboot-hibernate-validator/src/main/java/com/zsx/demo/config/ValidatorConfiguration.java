package com.zsx.demo.config;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.cfg.ConstraintMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @date 2021/11/9
 */
@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();

        // 第二种写法
        //ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
        //        .configure()
        //        .addProperty("hibernate.validator.fail_fast", "true")
        //        .buildValidatorFactory();

        return validatorFactory.getValidator();
    }

}
