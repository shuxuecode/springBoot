package com.zsx.leetcode;

public class Num21 {

    public static void main(String[] args) {

        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);

        listNode1_1.next = listNode1_2;

        ListNode listNode2_1 = new ListNode(2);
        ListNode listNode2_2 = new ListNode(3);

        listNode2_1.next = listNode2_2;

        new Num21().mergeTwoLists(listNode1_1, listNode2_1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode;
        int a, b;

        while (l1.next != null && l2.next != null) {

            a = l1.val;
            b = l2.val;

            if (a < b) {
                ListNode listNode1 = new ListNode(a);
                int next = l1.next.val;


            } else {
                ListNode listNode2 = new ListNode(b);
            }


        }


        return null;
    }

    ListNode getNext(ListNode listNode) {
        return listNode.next;
    }

}


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