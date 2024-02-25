package com.zsx.springboot320.dto;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class RequestDTO {


    private Integer id;

    private String name;


    private String nick;

    private Date birthday;

    private Long age;


    // get set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

//    tostring


    @Override
    public String toString() {

        return JSON.toJSONString(this);

        //return "RequestDTO{" +
        //        "id=" + id +
        //        ", name='" + name + '\'' +
        //        ", nick='" + nick + '\'' +
        //        ", birthday=" + birthday +
        //        ", age=" + age +
        //        '}';
    }
}
