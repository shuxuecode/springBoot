package com.zsx.springbootmybatisplus.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * @author zsx
 * @date 2021年06月29日 16:18
 */
@Data
// todo zsx
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)

@FluentMybatis(table = "t_user")
public class TUser extends RichEntity {

    @TableId(value = "id", auto = true)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

//    @TableField("create_time")
//    private Date createTime;
}
