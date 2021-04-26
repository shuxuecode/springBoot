package leetcode;

import org.junit.jupiter.api.Test;

public class N23 {

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


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;

        ListNode node = getMin(lists);
        while (node != null) {
            head.next = node;
            head = head.next;

            node = getMin(lists);
        }
        return listNode.next;
    }

    /**
     * 获取最小值
     *
     * @param lists
     * @return
     */
    public ListNode getMin(ListNode[] lists) {
        Integer min = null;
        int index = -1;
        ListNode node = null;
        for (int i = 0, len = lists.length; i < len; i++) {
            node = lists[i];
            if (node != null) {
                if (min == null) {
                    min = node.val;
                    index = i;
                } else if (node.val <= min) {
                    min = node.val;
                    index = i;
                }
            }
        }
        if (index == -1) {
            return null;
        }
        lists[index] = lists[index].next;
        return new ListNode(min);
    }


    @Test
    public void test() {
        //  [[1,4,5],[1,3,4],[2,6]]
        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(4, node11);
        ListNode node13 = new ListNode(1, node12);

        ListNode node21 = new ListNode(4);
        ListNode node22 = new ListNode(3, node21);
        ListNode node23 = new ListNode(1, node22);

        ListNode node31 = new ListNode(6);
        ListNode node32 = new ListNode(2, node31);

        ListNode[] lists = {node13, node23, node32};

//        for (ListNode list : lists) {
//            print(list);
//        }

//        [[1],[0]]
        ListNode node41 = new ListNode(1);
        ListNode node51 = new ListNode(0);

        ListNode[] lists2 = {node41, node51};

        ListNode listNode = mergeKLists(lists2);

        print(listNode);
    }

    public void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
