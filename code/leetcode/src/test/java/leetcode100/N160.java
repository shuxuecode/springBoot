package leetcode100;

import org.junit.jupiter.api.Test;

public class N160 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }


    // 双指针法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            if (a != null) {
                a = a.next;
            } else {
                a = headB;
            }
            if (b != null) {
                b = b.next;
            } else {
                b = headA;
            }
        }
        return a;
    }


    @Test
    public void test() {

        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2, node4);

        ListNode node1_1 = new ListNode(1, node2);
        ListNode node1_9 = new ListNode(9, node1_1);


        ListNode node2_3 = new ListNode(3, node2);

        System.out.println(node1_9.next.next == node2_3.next);

        ListNode listNode = getIntersectionNode(node1_9, node2_3);

        System.out.println(listNode);
        if (listNode != null) {
            System.out.println(listNode.val);
        }

    }

}
