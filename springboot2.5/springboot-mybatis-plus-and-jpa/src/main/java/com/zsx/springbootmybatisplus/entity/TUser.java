package com.zsx.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;
import org.springframework.data.annotation.Id;

import java.util.Date;


/**
 * @author zsx
 * @date 2021年06月29日 16:18
 */
@Data
public class TUser {

    /**
     * IdType.AUTO —— 数据库ID自增
     * IdType.NONE —— 该类型为未设置主键类型(注解里等于跟随全局,全局里约等于 INPUT)
     * IdType.INPUT —— 用户输入ID
     * IdType.ASSIGN_ID —— 分配ID (主键类型为number或string）
     * IdType.ASSIGN_UUID —— 分配UUID (主键类型为 string)
     */
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 不能使用这种方式
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    // 该注解： 当执行insert语句才进行填充这个字段
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
