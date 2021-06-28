package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 */
public class N1669 {

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


    // 通过，击败了75.92%
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode node = list1;

        ListNode left = null;
        ListNode right = null;

        int i = 0;
        while (node != null) {
            if (i + 1 == a) {
                left = node;
            }
            if (i == b) {
                right = node.next;
            }
            node = node.next;
            i++;
        }

        left.next = list2;

        ListNode curNode = left;
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        curNode.next = right;

        return list1;
    }

    @Test
    void t() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node11 = new ListNode(11);
        ListNode node22 = new ListNode(22);

        node11.next = node22;

        ListNode listNode = mergeInBetween(node1, 1, 2, node11);

        print(listNode);
    }

    public void print(ListNode root) {
        System.out.println();
        while (root != null) {
            System.out.print(root.val);
            System.out.print(" , ");
            root = root.next;
        }
        System.out.println();
    }
}
