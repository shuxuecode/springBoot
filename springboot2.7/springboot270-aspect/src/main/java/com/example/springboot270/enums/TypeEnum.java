package com.example.springboot270.enums;

/**
 * @date 2022/7/5
 */
public enum TypeEnum {

    CREATE("CREATE", "a"),
    UPDATE("UPDATE", "b"),
    DELETE("DELETE", "c"),
    //
    ;


    TypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
