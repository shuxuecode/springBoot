package com.zsx.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsx.springbootmybatisplus.dao.UserDao;
import com.zsx.springbootmybatisplus.entity.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Test
    void t10() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        executorService.submit(() -> {
            String result = "";
            transactionTemplate.execute(status -> {
                TUser user = userDao.lock("123");
                System.out.println("1 = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss:SSS")));
                sleep(2);

                return result;
            });
        });

        executorService.submit(() -> {
            String result = "";
            transactionTemplate.execute(status -> {
                TUser user = userDao.lock("123");
                //userDao.lock("222");
                System.out.println("2 = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss:SSS")));
                sleep(2);

                return result;
            });
        });

        executorService.shutdown();

        TimeUnit.SECONDS.sleep(8);
    }

    private void sleep(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 链式查询方式
    @Test
    void t9() {
        LambdaQueryChainWrapper<TUser> wrapper = new LambdaQueryChainWrapper<TUser>(userDao);
        //wrapper.eq(TUser::getUsername, "shu");
        wrapper.isNotNull(TUser::getUsername);

        List<TUser> list = wrapper.list();

        list.forEach(System.out::println);

    }

    @Test
    void t8() {
        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TUser::getUsername, "shu");

        List<TUser> list = userDao.selectList(queryWrapper);

        list.forEach(System.out::println);

    }

    @Test
    void t7() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startTime = LocalDateTime.parse("2020-11-02 00:00:00", formatter);
        LocalDateTime endTime = LocalDateTime.parse("2020-11-27 14:28:52", formatter);

        Instant instant = startTime.atZone(ZoneId.systemDefault()).toInstant();
        Date startDate = Date.from(instant);

        Date endDate = Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant());


        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.between("create_time", startDate, endDate);

//        queryWrapper.ge("create_time", startDate);
        queryWrapper.le("create_time", startDate);

        List<TUser> list = userDao.selectList(queryWrapper);

        list.forEach(System.out::println);
    }


    @Test
    void t6() {

//        更新指定字段
        TUser user = new TUser();
        user.setUsername("shu");

        userDao.update(user, Wrappers.<TUser>lambdaUpdate().eq(TUser::getId, 1));
    }


    @Test
    void t5() {
        TUser tUser = userDao.selectById(11);

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
        user.setUsername("c");
        user.setPassword("c");

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
