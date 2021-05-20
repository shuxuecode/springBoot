package leetcode;

import org.junit.jupiter.api.Test;

public class N82 {

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

    // 去掉重复的，但没有删除重复的节点
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        int val = node.val;
        while (node != null && node.next != null) {
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            if (node.next != null) {
                val = node.next.val;
            }
            node = node.next;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode node = root;

        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                int val = node.next.val;
                while (node.next != null && node.next.val == val) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }
        return root.next;
    }

    @Test
    void t() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        print(node1);

        ListNode listNode = deleteDuplicates(node1);

        print(listNode);

    }


    public void print(ListNode root) {
        System.out.println();
        ListNode node = root;
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" , ");
            node = node.next;
        }
        System.out.println();
    }
}
