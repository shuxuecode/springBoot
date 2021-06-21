package com.zsx.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Test1 {


    @Test
    void t(){
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(2));
        }
    }

    @Test
    public void t1() {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.isEmpty());
        // 添加
        queue.offer(1);
        queue.offer(2);

        System.out.println(queue);

        System.out.println(queue.peek());

        System.out.println(queue);

        System.out.println(queue.poll());
        // 同 offer ，但如果队列满了调用add会抛一个unchecked异常
        queue.add(3);

        System.out.println(queue);
        System.out.println(queue);
        System.out.println(queue);
    }

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
