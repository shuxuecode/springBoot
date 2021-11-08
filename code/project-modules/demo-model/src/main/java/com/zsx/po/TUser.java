package com.zsx.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @date 2021/11/8
 */
@Data
public class TUser {

    @Id
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Date createTime;
}
