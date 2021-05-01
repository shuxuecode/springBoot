package leetcode;

import org.junit.jupiter.api.Test;

public class N19 {
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


    public ListNode removeNthFromEnd(ListNode head, int n) {
//        声明一个虚拟头部节点
        ListNode root = new ListNode(0, head);
//        用于节点移动
        ListNode node = root;
//        首先移动的节点，该节点与后面的节点保持间隔n个节点，
//        当该节点到结尾时，那么后面的节点正好是倒数第n个节点
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
//            先移动节点到第n个节点
            cur = cur.next;
        }

        while (cur != null) {
//            同时移动
            node = node.next;
            cur = cur.next;
        }
//        删除倒数第N个节点
        node.next = node.next.next;
        return root.next;
    }


    @Test
    public void test() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

//        print(node1);

        ListNode listNode = removeNthFromEnd(node1, 2);

        print(listNode);
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
