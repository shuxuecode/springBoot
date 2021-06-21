package leetcode300;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author zsx
 */
public class N382 {

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

    ListNode head;
    Random random;


    public N382(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int res = 0;
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;

            if ((random.nextInt(count) + 1) % count == 0) {
                res = node.val;
            }

            node = node.next;
        }
        return res;
    }


    @Test
    void t() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        N382 n382 = new N382(node1);

        for (int i = 0; i < 20; i++) {
            int random = n382.getRandom();
            System.out.println(random);
        }

    }


}
