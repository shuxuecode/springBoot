package com.springboot354.demo;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot354.demo.entity.User;
import com.springboot354.demo.mapper.UserMapper;
import com.springboot354.demo.repository.UserRepository;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Date;
import java.util.List;

@Data
@SpringBootTest
class Springboot354ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Test
    @Transactional
    void t06() {

        System.out.println(TransactionSynchronizationManager.isSynchronizationActive());

        String username = "abcdef";
        User user = new User();
        user.setUsername(username);
        user.setPassword("1234");
        user.setCreatedTime(new Date());

        User user1 = userRepository.save(user);

        User user2 = userMapper.selectByName(username);

        System.out.println(JSON.toJSONString(user2));


    }

    @Test
    void t05() {
        User user = new User();
        user.setUsername("abc");
        User user1 = userMapper.test(user);
        System.out.println(user1);
        System.out.println(JSON.toJSONString(user1));
    }

    @Test
    void t04() {
        User abc = userMapper.selectByName("abc");
        System.out.println(abc);
        System.out.println(JSON.toJSONString(abc));
    }

    @Test
    void t03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "abc");
        List<User> user2s = userMapper.selectList(queryWrapper);
        System.out.println(user2s);
        System.out.println(JSON.toJSONString(user2s));

        userRepository.flush();

    }

    @Test
    void t02() {

        User user = new User();
        user.setUsername("abc");
        user.setPassword("123");
        user.setCreatedTime(new Date());

        User user1 = userRepository.save(user);

        System.out.println(user1);

    }

    @Test
    void t01() {

        User abc = userRepository.findByUsername("abc");

        System.out.println(abc);
        System.out.println(JSON.toJSONString(abc));


    }
}
