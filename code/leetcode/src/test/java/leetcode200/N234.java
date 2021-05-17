package leetcode200;

import com.sun.javafx.scene.control.SizeLimitedList;
import jdk.nashorn.internal.ir.IfNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class N234 {

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

    // 先反转链表，再依次比较
    public boolean isPalindrome2(ListNode head) {
        ListNode reverse = reverse(head);

        while (head != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }

        return true;
    }

    // 反转得到一个新的链表
    public ListNode reverse(ListNode head) {
        ListNode node = head;

        ListNode newHead = null;
        while (node != null) {
            ListNode newNode = new ListNode(node.val);
            newNode.next = newHead;

            newHead = newNode;

            node = node.next;
        }
        return newHead;
    }

    // 快慢指针得到中间节点，然后比较，注意：需要额外判断节点个数是奇数还是偶数，才能取到具体的中间节点
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ArrayList<Integer> list = new ArrayList<>();
        // 是否为奇数个节点
        boolean isOdd = true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            list.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                // 节点个数为偶数
                isOdd = false;
            } else if (fast.next == null) {
                // 节点个数为奇数
                isOdd = true;
            }
        }

        // slow 就是中间节点

        ListNode next = isOdd ? slow.next : slow;

        for (int i = list.size() - 1; i >= 0; i--) {
            if (next.val != list.get(i)) {
                return false;
            }
            next = next.next;
        }

        return true;
    }

    // 将链表转为数组后再比较
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // todo 还有一种慢指针反转前半部分的链表，然后再跟后半部分的链表进行比较的解法


    @Test
    void t() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        boolean bool = isPalindrome(node1);

        System.out.println(bool);

//        ListNode reverse = reverse(node1);
//        System.out.println(reverse);
    }

    public void print(ListNode root) {
        System.out.println();
        ListNode node = root;
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" , ");
            node = node.next;
        }
        System.out.println();
    }
}
