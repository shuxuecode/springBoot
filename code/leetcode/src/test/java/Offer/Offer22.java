package Offer;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 * @date 2021/9/2
 */
public class Offer22 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // 双指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        for (int i = 0; i < k; i++) {
            if (first != null) {
                first = first.next;
            }
        }
        if (first == null) {
            return head;
        }
        ListNode second = head;
        while (first != null){
            first = first.next;
            second = second.next;
        }

        return second;
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
        node5.next = node6;

        ListNode kthFromEnd = getKthFromEnd(node1, 3);

        System.out.println(kthFromEnd.val);
    }
}
