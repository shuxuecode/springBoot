package com.zsx.springboot;

import com.zsx.springboot.dao.UserDao;
import com.zsx.springboot.entity.Tuser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot241ApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
        List<Tuser> list = userDao.findAll();

        for (Tuser tuser : list) {
            System.out.println(tuser.getId());
            System.out.println(tuser.getUsername());
            System.out.println();

        }
    }

}
