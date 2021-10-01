package guavaTest;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zsx
 * @date 2021/9/3
 */
public class GuavaTest1 {


    // 字符串操作
    @Test
    void t1() {
        // 拼接
        Joiner joiner = Joiner.on(",").skipNulls();

        String joinStr = joiner.join("a", "b", "c");

        System.out.println(joinStr);

        joinStr = joiner.join(Lists.newArrayList("a", "b", "c", "d"));
        // 存在null也不用担心
        joinStr = joiner.join(Lists.newArrayList("a", "b", null, "c", "d"));

        System.out.println(joinStr);

        //    分隔
        Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();

        List<String> list = splitter.splitToList(joinStr);

        System.out.println(list);
        // 不用关注空值的情况
        Stream<String> stream = splitter.splitToStream("a,,,b,c,,");

        stream.forEach(System.out::println);


    }


    // guava提供了Bytes/Shorts/Ints/Iongs/Floats/Doubles/Chars/Booleans这些基本数据类型的扩展支持
    @Test
    void t2() {
        // 数组拼接
        int[] concat = Ints.concat(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(Arrays.toString(concat));

        // 取最大值，最小值
        int max = Ints.max(concat);
        Ints.min(concat);

        //    判断是否包含
        boolean contains = Ints.contains(concat, 3);
        System.out.println(contains);


    }

    @Test
    void t3() {
        // 可重复且无序的set
        HashMultiSet<Integer> multiSet = new HashMultiSet<>();

        multiSet.add(1);
        multiSet.add(2);
        multiSet.add(2);
        multiSet.add(3);
        multiSet.add(3);

        System.out.println(multiSet.size()); // 5
        System.out.println(multiSet); // [1:1, 2:2, 3:2]

    }


    @Test
    void t4() {
        // 一个key对应多个value
        ArrayListMultimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("a", "a");
        multimap.put("a", "aa");

        multimap.put("b", "b");

        multimap.put("c", "c");
        multimap.put("c", "d");

        System.out.println(multimap); // {a=[a, aa], b=[b], c=[c, d]}
    }

    @Test
    void t5() {
        ImmutableMap<Object, Object> map = ImmutableMap.builderWithExpectedSize(4).put("1", "2").build();

        ImmutableMap<String, String> immutableMap = ImmutableMap.of("3", "4");

        System.out.println(map);
        System.out.println(immutableMap);

        HashMap<String, String> stringStringHashMap = new HashMap<>(immutableMap);

        System.out.println(stringStringHashMap);

        HashMap<String, String> hashMap = new HashMap() {

            {
                put("5", "6");
            }
        };

        System.out.println(hashMap);



    }

    @Test
    void t6(){
        Long id = 0L;

    }
}
