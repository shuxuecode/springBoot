package leetcode100;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class N138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        //创建一个哈希表，key是原节点，value是新节点
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node p = head;
        //将原节点和新节点放入哈希表中
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
        p = head;
        //遍历原链表，设置新节点的next和random
        while (p != null) {
            Node newNode = map.get(p);
            //p是原节点，map.get(p)是对应的新节点，p.next是原节点的下一个
            //map.get(p.next)是原节点下一个对应的新节点
            if (p.next != null) {
                newNode.next = map.get(p.next);
            }
            //p.random是原节点随机指向
            //map.get(p.random)是原节点随机指向  对应的新节点
            if (p.random != null) {
                newNode.random = map.get(p.random);
            }
            p = p.next;
        }
        //返回头结点，即原节点对应的value(新节点)
        return map.get(head);
    }


    @Test
    void t() {


        Node head = new Node(2);

        Node next = new Node(3);

        head.next = next;
        head.random = null;

        next.next = null;
        next.random = head;

        Node node = copyRandomList(head);

        print(node);
    }

    public void print(Node head) {
        while (head != null) {

            System.out.print("val = " + head.val);
            if (head.random != null) {
                System.out.print(" random =  " + head.random.val);
            }

            System.out.println();

            head = head.next;
        }
    }
}
