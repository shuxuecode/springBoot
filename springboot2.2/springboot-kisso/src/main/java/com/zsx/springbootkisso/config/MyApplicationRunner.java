package com.zsx.springbootkisso.config;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

@Configuration
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        MetricRegistry metricRegistry = new MetricRegistry();
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource) dataSource).setMetricRegistry(metricRegistry);
        }

        Slf4jReporter reporter = Slf4jReporter.forRegistry(metricRegistry).build();
        reporter.start(5, TimeUnit.MINUTES);
    }
}
