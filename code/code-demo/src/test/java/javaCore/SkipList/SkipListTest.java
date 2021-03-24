package javaCore.SkipList;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * 时间复杂度为O(logn)
 * *
 * 跳表具有如下性质：
 * (1) 由很多层结构组成
 * (2) 每一层都是一个有序的链表
 * (3) 最底层(Level 1)的链表包含所有元素
 * (4) 如果一个元素出现在 Level i 的链表中，则它在 Level i 之下的链表也都会出现。
 * (5) 每个节点包含两个指针，一个指向同一链表中的下一个元素，一个指向下面一层的元素。
 */
public class SkipListTest {

    public static void main(String[] args) {
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();

//        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(5);
        set.add(3);
        set.add(2);
        set.add(4);


        System.out.println(set);
    }

    @Test
    public void t1() {
        // 内部使用无锁CAS算法实现了同步
        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();

        map.put("a", new Random().nextInt(10));
        map.put("c", new Random().nextInt(10));
        map.put("d", new Random().nextInt(10));
        map.put("b", new Random().nextInt(10));

        System.out.println(map);

    }
}
