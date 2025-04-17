package com.zsx.springbootmybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 启动 分页插件
 * <p>
 * 可以多个插件共存
 *
 * @author zsx
 * @date 2021年06月29日 16:51
 */
@Configuration
public class MybatisPlusConfig {


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        return interceptor;
    }


    /**
     * pagehelper 分页插件
     *
     * @return
     */
    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }
}
