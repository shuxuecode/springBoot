package com.zsx.fluentmybatis;

import cn.org.atool.fluent.mybatis.If;
import com.github.pagehelper.PageHelper;
import com.zsx.fluentmybatis.entity.TUser;
import com.zsx.fluentmybatis.helper.TUserWrapperHelper;
import com.zsx.fluentmybatis.mapper.TUserMapper;
import com.zsx.fluentmybatis.wrapper.TUserQuery;
import com.zsx.fluentmybatis.wrapper.TUserUpdate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@SpringBootTest
class AppTests {

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

        String name = "a";
        name = "";

        TUserQuery query = TUserQuery.query()
                .where.username().eq(name, If::notBlank).end();

        List<TUser> list = tUserMapper.listEntity(query);

        list.forEach(System.out::println);

    }


    // 可以使用，但需要注入pagehelper拦截器
    @Test
    void pageHelper分页() {
        PageHelper.startPage(2,2);
        TUserQuery query = TUserQuery.query().where.end();

        List<TUser> list = tUserMapper.listEntity(query);

        list.forEach(System.out::println);
    }

    @Test
    void 分页() {

        TUserQuery query = TUserQuery.query().where.end().limit(1, 2);

        List<TUser> list = tUserMapper.listEntity(query);

        list.forEach(System.out::println);
    }


    /**
     * 语法：以set开头，更新对应的字段值，以end()结束
     * <p>
     * .update.字段1().is(设置值)
     * .set.字段2().is(设置值)
     * .set.字段3().is(设置值)
     * .end()
     * .where.条件设置.end()
     * <p>
     * 示例代码
     *
     * @Test void test_update() {
     * mapper.updateBy(new UserUpdate()
     * .update.age().is(34).end()
     * .where.id().eq(2).end()
     * );
     * }
     * <p>
     * 对应sql语句
     * <p>
     * UPDATE t_user SET gmt_modified = now(), age = ? WHERE id = ?
     */
    @Test
    void 显式指定字段更新() {
        TUserUpdate userUpdate = TUserUpdate.defaultUpdater()
                .update.username().is("a")
                .set.password().is("a")
                .end().where.id().eq(5).end();

        int update = tUserMapper.updateBy(userUpdate);

        System.out.println("update : " + update); // 1

    }

    @Test
    void 更新() {

        TUser user = tUserMapper.findById(5);
        if (user != null) {
            user.setUsername("5");

            // 这种是全字段更新
//            int update = tUserMapper.updateById(user);

            // 这种方式导致全部数据的username的值为b
            // sql ： update user set username = 'b'
            // 这种方式错误
//            TUserUpdate userUpdate = TUserUpdate.defaultUpdater().set.username().is("b").end();
//            int update = tUserMapper.updateBy(userUpdate);

//            System.out.println("update : " + update);
        }


    }

    @Test
    void 新增() {

        TUser user = new TUser();
        user.setUsername("bb");
        user.setPassword("bb");

        Serializable save = tUserMapper.save(user);
        // 这种方式不推荐
//        boolean b = tUserMapper.saveOrUpdate(user);

        System.out.println("save : " + save); // null
        System.out.println(user);
        System.out.println(user.getId());

        System.out.println();
//        System.out.println(b);
    }


    /*
    语法：
     .where
    .字段().条件(条件参数)
    .end()
    * */
    @Test
    void 条件查询() {

        TUserQuery query = TUserQuery.query()
                .where.username().like("a")
                .and.password().like("a")

                .end();

        List<TUser> list = tUserMapper.listEntity(query);

        list.forEach(System.out::println);
    }


    @Test
    void 返回指定字段() {
        TUserQuery query = TUserQuery.query().select.username().end().where.end();
        // 还可以指定别名
        query = TUserQuery.query().select.username("姓名").end().where.end();

        List<TUser> list = tUserMapper.listEntity(query);

        list.forEach(System.out::println);
    }


    @Test
    void 查询() {
        TUserQuery userQuery = TUserQuery.query().where.username().notNull().end();
        userQuery = TUserQuery.query().where.end();

        // 排序
        userQuery = TUserQuery.query().where.end()
                .orderBy.id().desc().end();

        List<TUser> list = tUserMapper.listEntity(userQuery);

        list.forEach(System.out::println);


    }

}
