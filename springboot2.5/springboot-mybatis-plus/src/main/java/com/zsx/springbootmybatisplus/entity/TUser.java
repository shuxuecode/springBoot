package com.zsx.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
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

    private Date createTime;
}
