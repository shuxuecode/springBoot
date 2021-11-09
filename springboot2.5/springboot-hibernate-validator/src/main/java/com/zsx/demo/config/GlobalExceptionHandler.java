package com.zsx.demo.config;

import com.alibaba.fastjson.JSON;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2021/11/9
 */
//@ControllerAdvice // 这个注解需要在下面每个方法上添加@RequestBody
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 捕获所有异常，主要为了打印具体的异常
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Map exceptionHandler(Exception e) throws Exception {

        System.out.println(8899);
        System.out.println(e.toString());

        throw e;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Map methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder msg = new StringBuilder();
        for (ObjectError error : allErrors) {
            msg.append(error.getDefaultMessage()).append(",");
        }

        Map<String, String> map = new HashMap<>(4);
        map.put("errorMsg", msg.toString());
        return map;
    }


    @ExceptionHandler(value = BindException.class)
    public Map bindExceptionHandler(BindException e) {
        BindingResult bindingResult = e.getBindingResult();

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder msg = new StringBuilder();
        for (ObjectError error : allErrors) {
            msg.append(error.getDefaultMessage()).append(",");
        }

        Map<String, String> map = new HashMap<>(4);
        map.put("errorMsg", msg.toString());
        return map;
    }


}
