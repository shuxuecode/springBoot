package com.zsx.test01;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
public class Test01 {

    public static void main(String[] args) {


        String str = "[{\"amount\":1,\"templateId\":\"1\"}]";

        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> collect = list.stream().filter(item -> item.equals(0)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
