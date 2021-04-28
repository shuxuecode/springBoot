package com.zsx.springbootkisso.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zsx.springbootkisso.dao.TuserDao;
import com.zsx.springbootkisso.entity.Tuser;
import com.zsx.springbootkisso.service.UserService;
import com.zsx.springbootkisso.utils.SecureUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Resource
    private TuserDao tuserDao;

    @Override
    public Tuser getUser(String username) {
        List<Tuser> userList = tuserDao.findByDeletedAndUsername(0, username);
        logger.info("根据username= {} 查询用户表，结果为：{}", username, JSON.toJSONString(userList));
        if (CollectionUtils.isNotEmpty(userList)) {
            Tuser tuser = userList.get(0);
            String password = tuser.getPassword();
            if (StringUtils.isNotBlank(password)) {
                String decrypt = SecureUtil.decrypt(password);
                tuser.setPassword(decrypt);
            }
            return tuser;
        }
        return null;
    }

    @Override
    public String getUser(Integer id) {
        List<Tuser> list = tuserDao.findByDeletedAndId(0, id);
        logger.info("根据主键id= {} 查询用户表，结果为：{}", id, JSON.toJSONString(list));
        if (CollectionUtils.isNotEmpty(list)) {
            return JSON.toJSONString(list.get(0));
        }
        return null;
    }

    @Override
    public JSONObject addUser(String username, String password) {
        JSONObject json = new JSONObject();

        List<Tuser> list = tuserDao.findByDeletedAndUsername(0, username);
        logger.info("根据username= {} 查询用户表，结果为：{}", username, JSON.toJSONString(list));
        if (CollectionUtils.isNotEmpty(list)) {
            json.put("success", false);
            json.put("message", "用户名已存在，请更换后重试");
            return json;
        }

        password = SecureUtil.encrypt(password);

        Tuser tuser = new Tuser();
        tuser.setUsername(username);
        tuser.setPassword(password);

        tuser.setGender(0);
        tuser.setNickname(username);
        tuser.setMobile("");
        tuser.setAvatar("");
        tuser.setStatus(0);

        tuser.setDeleted(0);
        tuser.setCreateTime(new Date());
        tuser.setUpdateTime(new Date());

        tuserDao.save(tuser);

        json.put("success", true);
        json.put("message", "注册成功");
        return json;
    }
}
