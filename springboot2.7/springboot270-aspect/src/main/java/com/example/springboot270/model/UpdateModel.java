package com.example.springboot270.model;

import com.example.springboot270.enums.TypeEnum;

/**
 * @author 
 * @date 2022/7/5
 */
public class UpdateModel {

    private String name;

    private TypeEnum typeEnum = TypeEnum.UPDATE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }
}
