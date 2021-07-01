package com.zsx.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.annotation.Id;


/**
 * @author zsx
 * @date 2021年06月29日 16:18
 */
@Data
public class TUser {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 不能使用这种方式
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;
}
