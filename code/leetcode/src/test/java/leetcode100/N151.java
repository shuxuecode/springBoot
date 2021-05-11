package leetcode100;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class N151 {


    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();

        int left = 0;
        boolean isBlank = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (isBlank == false) {
                    String substr = s.substring(left, i);
                    list.add(substr);
                }
                left = i + 1;
                isBlank = true;
            } else {
                isBlank = false;
            }
        }

        if (left < s.length()) {
            String substr = s.substring(left);
            list.add(substr);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = list.size() - 1; i >= 0; i--) {

            sb.append(list.get(i));
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    @Test
    void t() {
        String s = "the sky is blue";
        s = "  Bob    Loves  Alice   ";
        s = "a good   example";
        String words = reverseWords(s);

        System.out.println(words);
//        System.out.println("blue is sky the".equals(words));
    }
}
