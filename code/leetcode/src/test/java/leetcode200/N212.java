package leetcode200;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 */
public class N212 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();


        return res;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int k) {
        char[] chars = board[i];
        if (chars[j] == word.charAt(k)) {
            boolean b = dfs(board, i++, j, word, k++);
            if (b) {

            }
        } else {
            return false;
        }
        return false;
    }

    @Test
    void t() {
        char[] a = {'o', 'a', 'a', 'n'};
        char[] b = {'e', 't', 'a', 'e'};
        char[] c = {'i', 'h', 'k', 'r'};
        char[] d = {'i', 'f', 'l', 'v'};

        List<String> list = findWords(new char[][]{a, b, c, d}, new String[]{"oath", "pea", "eat", "rain"});

        System.out.println(list);
    }
}
