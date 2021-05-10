package leetcode100;

import org.junit.jupiter.api.Test;

public class N141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 快慢指针
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);

        node3.next = node2;
        node2.next = node0;
        node0.next = node1;
        node1.next = node2;


        boolean hasCycle = hasCycle(node3);

        System.out.println(hasCycle);

    }
}
