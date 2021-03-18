package com.zsx.leetcode;

import java.util.Stack;

public class Test1 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);

        Integer pop = stack.pop();
        System.out.println(pop);

        Integer peek = stack.peek();
        System.out.println(peek);

        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println();
        if (!stack.empty()) {
            System.out.println(stack.pop());
        }


    }

}
