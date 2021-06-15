package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 */
public class N24 {

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

    // 100%通过
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode();
        root.next = head;

        ListNode cur = root;

        while (cur.next != null && cur.next.next != null) {
            ListNode node = cur.next;
            ListNode next = cur.next.next;

            node.next = next.next;
            next.next = node;
            cur.next = next;

            cur = cur.next.next;
        }

        // 下面是思路
//        ListNode cur = head;
//        ListNode next = head.next;
//
//        cur.next = next.next;
//        next.next = cur;
//        root.next = next;

        return root.next;
    }

    @Test
    void t() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode listNode = swapPairs(node1);

        print(listNode);
    }

    public void print(ListNode root) {
        while (root != null) {
            System.out.print(root.val);
            System.out.print(" , ");
            root = root.next;
        }
        System.out.println();
    }
}
