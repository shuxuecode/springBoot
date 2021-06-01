package leetcode300;

import org.junit.jupiter.api.Test;

/**
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 **/

public class N328 {

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


    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode nextListNode = node2;

        while (node2 != null && node2.next != null) {
            node1.next = node1.next.next;
            node2.next = node2.next.next;
            node1 = node1.next;
            node2 = node2.next;
        }

        node1.next = nextListNode;

        return head;
    }

    @Test
    void t() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = oddEvenList(listNode1);

        print(listNode);

    }


    public void print(ListNode root) {
        ListNode listNode = root;
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print(" , ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
