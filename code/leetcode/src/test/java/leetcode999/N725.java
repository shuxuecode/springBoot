package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author zsx
 * @date 2021/9/22
 */
public class N725 {

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


    // 可以通过，但性能差
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);

            head = head.next;
        }

        if (list.size() <= k) {
            for (int i = 0; i < list.size(); i++) {
                ListNode listNode = new ListNode(list.get(i));
                res[i] = listNode;
            }
        } else {
            // 余数
            int n = list.size() % k; // 10 % 3 = 1
            int m = list.size() / k; // 10 / 3 = 3
            int j = 0;

            for (int i = 0; i < k; i++) {
                ListNode listNode = new ListNode(list.get(j));
                res[i] = listNode;
                ListNode next = listNode;
                for (int l = 1; l < m; l++) {
                    j++;
                    next.next = new ListNode(list.get(j));

                    next = next.next;
                }
                if (n > 0) {
                    j++;
                    next.next = new ListNode(list.get(j));

                    next = next.next;
                    n--;
                }

                j++;
            }

        }

        return res;
    }

    // todo zsx 加个优化解法

    @Test
    void t() {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        ListNode[] listNodes = splitListToParts(head, 3);

        for (ListNode listNode : listNodes) {
            System.out.println(listNode.val);
        }
    }
}
