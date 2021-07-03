package com.zsx.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsx.springbootmybatisplus.dao.UserDao;
import com.zsx.springbootmybatisplus.entity.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    UserDao userDao;


    @Test
    void t6() {

//        更新指定字段
        TUser user = new TUser();
        user.setUsername("shu");

        userDao.update(user, Wrappers.<TUser>lambdaUpdate().eq(TUser::getId, 1));
    }


    @Test
    void t5() {
        TUser tUser = userDao.selectById(1);

        if (tUser != null) {
            tUser.setUsername("zhao");
//          更新整行记录
            int updateById = userDao.updateById(tUser);

            System.out.println("updateById = " + updateById);

        }
    }


    @Test
    void t4() {

        PageHelper.startPage(1, 3);
        List<TUser> list = userDao.testGet();

        PageInfo<TUser> pageInfo = new PageInfo<>(list);

        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getSize());

    }


    @Test
    void t3() {
        TUser user = new TUser();
        user.setUsername("b");
        user.setPassword("b");

        userDao.insert(user);

        System.out.println(user.getId());
    }

    @Test
    void t2() {
        List<TUser> list = userDao.testGet();
        list.forEach(System.out::println);
    }

    @Test
    void t1() {

        // eq 等于
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<TUser>().eq("id", "2");

        queryWrapper = new QueryWrapper<TUser>().like("username", "a");

        queryWrapper = new QueryWrapper<TUser>().like("username", "a");

//        LambdaUpdateWrapper<TUser> lambdaWrapper = Wrappers.<TUser>lambdaUpdate().between(TUser::getId, 2, 3);

        Map<String, String> params = new HashMap<>();
        params.put("username", "a");
        params.put("password", "a");
        // allEq  全部等于   ，  第二个参数 null2IsNull : 为true则在map的value为null时调用 isNull 方法,为false时则忽略value为null的
        queryWrapper = new QueryWrapper<TUser>().allEq(params);


        // ne 不等于

        // gt 大于   ge 大于等于
        // lt 小于   le 小于等于

        // like : LIKE '%值%'    notLike :  NOT LIKE '%值%'

        // likeLeft  : LIKE '%值'    likeRight : LIKE '值%'


        // in
        queryWrapper = new QueryWrapper<TUser>().in("id", Arrays.asList(1, 3));


        // or  and


        List<TUser> list = userDao.selectList(queryWrapper);

        list.forEach(System.out::println);
    }


    @Test
    void contextLoads() {

        System.out.println(123);
//        List<TUser> list = userDao.selectList(null);
//
//        list.forEach(System.out::println);

        Page<TUser> page = new Page<>(1, 2);
        page.addOrder(OrderItem.desc("id"));

        Page<TUser> pageData = userDao.selectPage(page, null);

        System.out.println(pageData.getTotal());

        List<TUser> records = pageData.getRecords();

        records.forEach(System.out::println);
    }

}
