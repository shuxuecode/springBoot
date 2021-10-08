package leetcode100;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @date 2021/10/8
 */
public class N187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);

            if (map.get(str) == 2) {
                res.add(str);
            }
        }

        return res;
    }

    @Test
    void t() {
        List<String> list = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");


        System.out.println(list);
    }

}
