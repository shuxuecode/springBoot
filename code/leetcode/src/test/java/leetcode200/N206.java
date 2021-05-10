package leetcode200;

import org.junit.jupiter.api.Test;

public class N206 {

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


    @Test
    public void test() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("开始反转");

//        ListNode listNode = reverseList(node1);
        ListNode listNode = reverseList2(node1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定义两个节点，pre为上一个节点，next为当前节点
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            // 记录当前节点的下一个节点
            next = head.next;
            // 将当前节点的下一个节点指向上一个节点，实现反转
            head.next = pre;
            // 节点分别往前移动，以实现下一个节点的反转
            pre = head;
            head = next;
        }
        return pre;
    }


}


