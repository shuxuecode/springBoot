package com.springboot354.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot354.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 添加自定义 SQL 方法


}
