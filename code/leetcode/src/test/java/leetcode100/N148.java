package leetcode100;

import org.junit.jupiter.api.Test;

public class N148 {

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


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = getMid(head);

        ListNode rightNode = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);

        return merge(left, right);
    }

    // 通过快慢指针获取中间节点
    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode root = new ListNode(0);
        ListNode curNode = root;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curNode.next = left;
                left = left.next;
            } else {
                curNode.next = right;
                right = right.next;
            }
            curNode = curNode.next;
        }

        if (left != null){
            curNode.next = left;
        }
        if (right != null){
            curNode.next = right;
        }
        return root.next;
    }

    @Test
    public void test() {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5, listNode3);
        ListNode listNode1 = new ListNode(1, listNode5);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode6 = new ListNode(6, listNode2);
        ListNode listNode4 = new ListNode(4, listNode6);

        ListNode root = new ListNode(0, listNode4);

        print(root.next);

//        ListNode mid = getMid(root.next);
//        System.out.println(mid.val);

        ListNode result = sortList(root.next);

        print(result);
    }

    public void print(ListNode listNode) {
        System.out.println();
        ListNode node = listNode;
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" , ");

            node = node.next;
        }
        System.out.println();
    }


}
