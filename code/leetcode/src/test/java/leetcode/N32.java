package leetcode;

import org.junit.jupiter.api.Test;

public class N32 {

    @Test
    public void test() {
        int i = longestValidParentheses(")()()()((");
        System.out.println(i);
    }

    // TODO zsx  这个不对
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] = dp[i] + dp[i - 2];
                    }
                } else if (dp[i - 1] > 0) {
                    if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == ')') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // TODO zsx
    public int longestValidParentheses2(String s) {
        if (null == s) return 0;

        int len = s.length(), max = 0;
        int[] d = new int[len];


        for (int index = len - 2; index >= 0; index--) {
            int symIndex = index + 1 + d[index + 1];
            if ('(' == s.charAt(index) && symIndex < len && ')' == s.charAt(symIndex)) {
                d[index] = d[index + 1] + 2;
                if (symIndex + 1 < len) {
                    d[index] += d[symIndex + 1];
                }
            }

            max = Math.max(max, d[index]);
        }
        return max;
    }
}
