package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class N20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            //
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            }

            if (chars[i] == ')') {
                if (stack.empty()) {
                    return false;
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else if (chars[i] == '}') {
                if (stack.empty()) {
                    return false;
                } else {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else if (chars[i] == ']') {
                if (stack.empty()) {
                    return false;
                } else {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

    @Test
    public void test() {
        String s = "()[]{}";

        boolean valid = isValid(s);

        System.out.println(valid);

    }

}
