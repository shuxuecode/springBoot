package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsx
 */
public class N68 {


    // 1ms 击败了70%
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int length = words.length;

        int i = 0;
        int j = 0;
        int len = 0;
        while (j < length) {
            System.out.println(len);
            if (len + words[j].length() + (j - i) > maxWidth) {
                //
                res.add(getStr(words, maxWidth, len, i, j - 1));
                i = j;
                len = 0;
            } else {
                len += words[j].length();
                j++;
            }
        }

        if (i < length) {
            res.add(getStr(words, maxWidth, len, i, j - 1));
        }

        return res;
    }

    public String getStr(String[] words, int maxWidth, int len, int i, int j) {

        // 获取中间有几个间隔，1个单词为0，2个单词为1个
        int num = j - i;

        if (num == 0) {
            // 说明只有一个单词，直接拼接即可
            return words[i] + createBlankSpace(maxWidth - len);
        }

        // 最后一行，特殊处理，左对齐，且无额外的空格
        if (j + 1 == words.length) {
            StringBuilder sb = new StringBuilder();
            for (int k = i; k <= j; k++) {
                sb.append(words[k]);

                if (k < j) {
                    sb.append(createBlankSpace(1));
                } else {
                    sb.append(createBlankSpace(maxWidth - sb.length()));
                }
            }
            return sb.toString();
        }

        // 空格的个数
        int count = maxWidth - len;
        // 每个间隔之间的空格数
        int m = count / num;
        // 最后补位的空格数
        int n = count % num;

        StringBuilder sb = new StringBuilder();
        for (int k = i; k <= j; k++) {
            sb.append(words[k]);

            if (k < j) {
                if ((k - i) < n) {
                    sb.append(createBlankSpace(m + 1));
                } else {
                    sb.append(createBlankSpace(m));
                }
            }
        }
        return sb.toString();
    }

    public String createBlankSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }


    @Test
    void t() {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
//        int maxWidth = 16;

        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;

        List<String> strings = fullJustify(words, maxWidth);

        System.out.println(strings);
        for (String string : strings) {
            System.out.print("\"");
            System.out.print(string);
            System.out.println("\"");
        }
    }

}
