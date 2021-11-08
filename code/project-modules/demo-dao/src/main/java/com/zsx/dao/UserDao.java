package com.zsx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsx.po.TUser;

import java.util.List;

/**
 * @date 2021/11/8
 */
public interface UserDao extends BaseMapper<TUser> {

    List<TUser> getAll();

}
