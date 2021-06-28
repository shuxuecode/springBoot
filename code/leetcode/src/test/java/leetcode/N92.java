package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 */
public class N92 {

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


    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode root = new ListNode();
        root.next = head;

        // 初始化指针
        ListNode pre = root;

        // 移动指针
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        // 定义head
        head = pre.next;

        // 头插法
        for (int i = left; i < right; i++) {
            ListNode next = head.next;

            head.next = next.next;

            next.next = pre.next;
            pre.next = next;
        }

        return root.next;
    }


//    public ListNode reverseNode(ListNode a, ListNode b) {
//        ListNode pre = null;
//        ListNode cur = a;
//        ListNode next = null;
//
//        while (cur != b) {
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//
//        System.out.println(cur);
//
//        return pre;
//    }


    @Test
    void t() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = reverseBetween(node1, 2, 4);

        print(listNode);
    }

    public void print(ListNode node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" , ");
            node = node.next;
        }
        System.out.println();
    }
}
