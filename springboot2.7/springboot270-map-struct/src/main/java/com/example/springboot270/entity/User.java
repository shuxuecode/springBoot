package com.example.springboot270.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author
 * @date 2022/5/17
 */
@Data
public class User {
    private Integer id;
    private String name;

    private Date birthday;
}
