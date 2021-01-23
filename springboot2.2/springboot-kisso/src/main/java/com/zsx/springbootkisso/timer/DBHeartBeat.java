package com.zsx.springbootkisso.timer;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component
public class DBHeartBeat {

    private static final Logger logger = LoggerFactory.getLogger(DBHeartBeat.class);

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    //    @Scheduled(fixedRate = 600000) // 每隔10分钟执行一次
//    @Scheduled(fixedRate = 1000) // 每隔1秒执行一次
    @Scheduled(cron = "*/10 * * * * * ")
    public void sql() {
        System.out.println(123);
        jdbcTemplate.execute("select count(1) from t_user");
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select count(1) from t_user");
        logger.info("{}", JSON.toJSONString(maps));

    }

}
