package javaCore.java8Stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @date 2021/12/13
 */
public class StreamSortTest {

    @Test
    void t() {

        ArrayList<Demo> list = Lists.newArrayList();

        //list.add(new Demo("b", 2));
        list.add(new Demo("xx", 5));
        list.add(new Demo("e", 5));
        //list.add(new Demo("a", 1));
        //list.add(new Demo("h", 3));
        //list.add(new Demo("c", 3));

        //list.stream().sorted(new Comparator<Demo>() {
        //    @Override
        //    public int compare(Demo o1, Demo o2) {
        //        return o1.getNum().compareTo(o2.getNum());
        //    }
        //});

        list.sort(Comparator.comparing(Demo::getNum));

        //list.sort((a, b) -> a.getNum() > b.getNum() ? -1 : 1);


        //Comparator<Demo> comparator1 = (a, b) -> a.getNum() > b.getNum() ? -1 : 1;
        Comparator<Demo> comparator1 = (a, b) -> a.getNum() > b.getNum() ? -1 : a.getNum() < b.getNum() ? 1 : 0;
        Comparator<Demo> comparator2 = (a, b) -> a.getName().length() < b.getName().length() ? -1 : 1;

        list.sort(comparator1.thenComparing(comparator2));

        System.out.println(JSON.toJSONString(list, true));
    }


    class Demo {
        private String name;
        private Integer num;

        public Demo(String name, Integer num) {
            this.name = name;
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }
}
