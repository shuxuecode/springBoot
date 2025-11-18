package com.springboot354.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot354.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // todo zsx


    @Select("select * from t_user where username = #{name}")
    User selectByName(@Param("name") String username);


    /**
     * 测试
     *
     * 在xml里面实现
     *
     * @param user
     * @return
     */
    User test(User user);

}
