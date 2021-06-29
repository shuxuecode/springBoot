package com.zsx.springbootmybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zsx.springbootmybatisplus.dao.UserDao;
import com.zsx.springbootmybatisplus.entity.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {

        System.out.println(123);
//        List<TUser> list = userDao.selectList(null);
//
//        list.forEach(System.out::println);

        Page<TUser> page = new Page<>(1,2);
        page.addOrder(OrderItem.desc("id"));

        Page<TUser> pageData = userDao.selectPage(page, null);

        System.out.println(pageData.getTotal());

        List<TUser> records = pageData.getRecords();

        records.forEach(System.out::println);
    }

}
