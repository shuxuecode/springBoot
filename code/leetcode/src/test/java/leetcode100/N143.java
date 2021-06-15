package leetcode100;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author zsx
 * todo
 */
public class N143 {
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


    // 耗时3ms，内存40.6MB
    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 1;
        int j = list.size() - 1;

        node = head;

        while (i < j) {
            node.next = list.get(j);
            node.next.next = list.get(i);

            node = node.next.next;

            i++;
            j--;
        }

        if (i == j) {
            node.next = list.get(i);
            node.next.next = null;
        } else {
            node.next = null;
        }
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
//        node5.next = node6;

        reorderList(node1);

        print(node1);
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
