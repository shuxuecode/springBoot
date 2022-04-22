package com.zsx.springbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsx.springbootmybatisplus.entity.TUser;

import java.util.List;

public interface UserDao extends BaseMapper<TUser> {


    List<TUser> testGet();

    TUser lock(String username);

    int updatePassword(TUser user);
}

