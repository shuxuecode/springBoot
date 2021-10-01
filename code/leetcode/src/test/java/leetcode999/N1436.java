package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shuxuezhao
 * @date 2021/10/1
 */
public class N1436 {

    public String destCity(List<List<String>> paths) {

        Set<String> from = new HashSet<>();
        Set<String> to = new HashSet<>();

        for (List<String> path : paths) {
            from.add(path.get(0));
            to.add(path.get(1));
        }

        for (String city : from) {
            if (to.contains(city)) {
                to.remove(city);
            }
        }

        return to.iterator().next();
    }

    @Test
    void t() {
        List<String> list1 = new ArrayList<>();
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<>();
        list2.add("D");
        list2.add("B");

        List<String> list3 = new ArrayList<>();
        list3.add("C");
        list3.add("A");

        List<List<String>> paths = new ArrayList<>();
        paths.add(list1);
        paths.add(list2);
        paths.add(list3);

        String city = destCity(paths);

        System.out.println(city);
    }
}
