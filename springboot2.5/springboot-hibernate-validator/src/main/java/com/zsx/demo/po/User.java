package com.zsx.demo.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @date 2021/11/8
 */
@Data
@NoArgsConstructor
public class User {

    @NotNull
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @Email(message = "邮箱格式错误")
    private String email;

    @NotBlank(message = "手机号不能为空")
    private String elephone;

    private Date birthday;
}
