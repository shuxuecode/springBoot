package com.zsx.springboot2711;

import com.github.liaochong.myexcel.core.DefaultStreamExcelBuilder;

import java.util.Map;
import java.util.concurrent.Executors;

/**
 * @date 2023/5/16
 */
public class Test {


    @org.junit.jupiter.api.Test
    void t1(){
        DefaultStreamExcelBuilder<Map> builder = DefaultStreamExcelBuilder.of(Map.class)
                .threadPool(Executors.newFixedThreadPool(10))
                .capacity(10_000)
                .start();

//        builder.

    }


}
