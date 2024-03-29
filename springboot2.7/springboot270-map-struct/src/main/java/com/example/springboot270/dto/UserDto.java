package com.example.springboot270.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author
 * @date 2022/5/17
 */
@Data
@ToString
public class UserDto {

    private Long id;

    private String userName;

    private Date birthday;
}
