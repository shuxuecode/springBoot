package com.zsx.fluentmybatis;

import com.github.pagehelper.PageHelper;
import com.zsx.fluentmybatis.entity.TUser;
import com.zsx.fluentmybatis.mapper.TUserMapper;
import com.zsx.fluentmybatis.wrapper.TUserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

//    @Autowired
//    UserDao userDao;
    @Autowired
    TUserMapper tUserMapper;
//    UserMapper userMapper;


    @Test
    void t7() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startTime = LocalDateTime.parse("2020-11-02 00:00:00", formatter);
        LocalDateTime endTime = LocalDateTime.parse("2020-11-27 14:28:52", formatter);

        Instant instant = startTime.atZone(ZoneId.systemDefault()).toInstant();
        Date startDate = Date.from(instant);

        Date endDate = Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant());


//        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.between("create_time", startDate, endDate);

//        queryWrapper.ge("create_time", startDate);
//        queryWrapper.le("create_time", startDate);

//        List<TUser> list = userDao.selectList(queryWrapper);

//        list.forEach(System.out::println);
    }


    @Test
    void t6() {

//        更新指定字段
        TUser user = new TUser();
        user.setUsername("shu");

//        userDao.update(user, Wrappers.<TUser>lambdaUpdate().eq(TUser::getId, 1));
    }


    @Test
    void t5() {
//        TUser tUser = userDao.selectById(1);

//        if (tUser != null) {
//            tUser.setUsername("zhao");
//          更新整行记录


//        }
    }


    @Test
    void t4() {

        PageHelper.startPage(1, 3);


    }


    @Test
    void t3() {
        TUser user = new TUser();
        user.setUsername("b");
        user.setPassword("b");

//        userDao.insert(user);

        System.out.println(user.getId());
    }

    @Test
    void t2() {
//        List<TUser> list = userDao.testGet();
//        list.forEach(System.out::println);
    }

    @Test
    void t1() {


    }


    @Test
    void contextLoads() {

        TUserQuery userQuery = TUserQuery.query().where.username().notNull().end();

        List<TUser> list = tUserMapper.listEntity(userQuery);

        list.forEach(System.out::println);



    }

}
