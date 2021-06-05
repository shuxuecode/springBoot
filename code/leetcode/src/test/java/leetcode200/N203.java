package leetcode200;

import org.junit.jupiter.api.Test;

public class N203 {

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


    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;

        ListNode node = newHead;

        while (node != null && node.next != null) {
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }

            node = node.next;
        }

        return newHead.next;
    }

    @Test
    void t() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

//        ListNode listNode = removeElements(node1, 6);
//        print(listNode);

        ListNode listNode4 = new ListNode(7);
        ListNode listNode3 = new ListNode(7, listNode4);
        ListNode listNode2 = new ListNode(7, listNode3);
        ListNode listNode1 = new ListNode(7, listNode2);

        ListNode listNode = removeElements(listNode1, 7);
        print(listNode);

    }

    public void print(ListNode listNode) {
        ListNode root = listNode;
        while (root != null) {
            System.out.print(root.val);
            System.out.print(" , ");

            root = root.next;
        }
        System.out.println();
    }
}
