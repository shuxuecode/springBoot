package javaCore.mapTest;

import org.junit.Test;

import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {

    @Test
    public void t1() {
        Random random = new Random();
        SortedMap<Integer, String> map = new TreeMap<Integer, String>();

        for (int i = 0; i < 6; i++) {
            map.put(random.nextInt(100), "");
        }
        System.out.println(map);
        int num = random.nextInt(50);
        System.out.println(num);
        SortedMap<Integer, String> tailMap = map.tailMap(num);

        System.out.println(tailMap);

        Integer firstKey = tailMap.firstKey();
        System.out.println(firstKey);


    }
}
