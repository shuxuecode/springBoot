package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 */
public class N2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        ListNode node = result;
        int tmp = 0;
        int count;

        while (l1 != null && l2 != null) {
            count = l1.val + l2.val + tmp;
            tmp = count / 10;

            node.next = new ListNode(count % 10);

            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }

        while (l1 != null) {
            count = l1.val + tmp;
            tmp = count / 10;

            node.next = new ListNode(count % 10);

            l1 = l1.next;
            node = node.next;
        }

        while (l2 != null) {
            count = l2.val + tmp;
            tmp = count / 10;

            node.next = new ListNode(count % 10);

            l2 = l2.next;
            node = node.next;
        }

        if (tmp > 0){
            node.next = new ListNode(tmp);
        }

        return result.next;
    }


    @Test
    void t() {

        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);

        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);

        node21.next = node22;
        node22.next = node23;

//        ListNode listNode = addTwoNumbers(node11, node21);
        ListNode listNode = addTwoNumbers(
                create(new int[]{9, 9, 9, 9, 9, 9, 9}),
                create(new int[]{9, 9, 9, 9}));


        print(listNode);

    }

    public void print(ListNode root) {
        ListNode node = root;
        while (node != null) {

            System.out.print(node.val);
            System.out.print(" , ");

            node = node.next;
        }
    }

    public ListNode create(int[] nums) {

        ListNode head = new ListNode();

        ListNode node = head;

        for (int num : nums) {
            node.next = new ListNode(num);

            node = node.next;
        }
        return head.next;
    }
}
