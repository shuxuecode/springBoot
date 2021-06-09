package leetcode;

import org.junit.jupiter.api.Test;

/**
 * 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * @author zsx
 */
public class N86 {

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

    // 100% 通过
    public ListNode partition(ListNode head, int x) {

        ListNode leftHead = new ListNode();
        ListNode rightHead = new ListNode();

        ListNode left = leftHead;
        ListNode right = rightHead;

        while (head != null) {
            if (head.val < x) {
                left.next = new ListNode(head.val);
                left = left.next;
            } else {
                right.next = new ListNode(head.val);
                right = right.next;
            }
            head = head.next;
        }

        left.next = rightHead.next;

        return leftHead.next;
    }


    @Test
    void t() {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);

        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;

        ListNode listNode = partition(node1, 3);

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
