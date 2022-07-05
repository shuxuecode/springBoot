package com.example.springboot270.service.impl;

import com.example.springboot270.model.CreateModel;
import com.example.springboot270.service.OperateHandler;

/**
 * @author 
 * @date 2022/7/5
 */
public class CreateOperateHandler extends OperateHandler<CreateModel> {

    public boolean match(CreateModel operate, String str){
        return true;
    }

    public String handle(CreateModel operate, Object obj){
        return null;
    }

}
