package leetcode;

import org.junit.jupiter.api.Test;

public class N83 {

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

    // 修改当前链表
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;

        int num = node.val;

        while (node.next != null) {
            while (node.next != null && node.next.val == num) {
                node.next = node.next.next;
            }

            if (node.next == null) {
                break;
            }

            num = node.next.val;

            node = node.next;
        }

        return head;
    }


    @Test
    void t() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
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
