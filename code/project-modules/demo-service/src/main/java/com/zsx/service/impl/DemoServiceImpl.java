package com.zsx.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zsx.dao.UserDao;
import com.zsx.po.TUser;
import com.zsx.service.DemoService;
import com.zsx.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @date 2021/11/8
 */
@Service
public class DemoServiceImpl implements DemoService {


    @Resource
    private UserDao userDao;

    @Override
    public List<UserVO> list() {
        //List<TUser> list = userDao.getAll();

        QueryWrapper<TUser> userQueryWrapper = new QueryWrapper<>();
        //userQueryWrapper.clear();

        List<TUser> list = userDao.selectList(userQueryWrapper);

        List<UserVO> result = JSONArray.parseArray(JSON.toJSONString(list), UserVO.class);

        return result;
    }
}
