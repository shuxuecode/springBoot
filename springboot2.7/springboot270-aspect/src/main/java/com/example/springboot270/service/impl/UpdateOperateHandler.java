package com.example.springboot270.service.impl;

import com.example.springboot270.model.UpdateModel;
import com.example.springboot270.service.OperateHandler;

/**
 * @author 
 * @date 2022/7/5
 */
public class UpdateOperateHandler extends OperateHandler<UpdateModel> {

    public boolean match(UpdateModel operate, String str){
        return true;
    }

    public String handle(UpdateModel operate, Object obj){
        return null;
    }

}
