package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 * @date 2021/9/24
 */
public class N430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }


    // todo zsx
    public Node flatten(Node head) {

        Node node = head;
        while (node != null) {

            Node child = node.child;
            if (child != null) {
                Node next = node.next;

                node.next = child;
                child.prev = node;

                child.next = next;
                next.prev = child;



            } else {

            }

            node = node.next;
        }

        return head;
    }


    @Test
    void t() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.prev = node1;

        node1.child = node3;

        Node node = flatten(node1);

        print(node);
    }

    private void print(Node node) {
        while (node != null) {
            System.out.print("prev=");

            if (node.prev != null) {
                System.out.print(node.prev.val);
            }

            System.out.print("   val=" + node.val);

            System.out.print("   next=");

            if (node.next != null) {
                System.out.print(node.next.val);
            }

            System.out.println();

            node = node.next;
        }
    }

}
