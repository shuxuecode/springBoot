package com.zsx.leetcode;

public class Num21 {

    public static void main(String[] args) {

        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);

        listNode1_1.next = listNode1_2;

        ListNode listNode2_1 = new ListNode(2);
        ListNode listNode2_2 = new ListNode(3);

        listNode2_1.next = listNode2_2;

//        ListNode listNode = new Num21().mergeTwoLists(listNode1_1, listNode2_1);
        ListNode listNode = new Num21().mergeTwoLists2(listNode1_1, listNode2_1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);

        ListNode tempNode = listNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tempNode.next = l1;
                tempNode = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                tempNode = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            tempNode.next = l1;
        }

        if (l2 != null) {
            tempNode.next = l2;
        }

        return listNode.next;
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode rootNode = new ListNode(0);
        ListNode curNode = rootNode;
        while (l1 != null && l2 != null) {
            boolean bool = l1.val < l2.val;

            curNode.next = bool ? l1 : l2;
            curNode = curNode.next;
            l1 = bool ? l1.next : l1;
            l2 = bool ? l2 : l2.next;
        }

        curNode.next = l1 == null ? l2 : l1;

        return rootNode.next;
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