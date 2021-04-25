package code.lru;

public class LruCache<V> {

    private int size = 0;
    private int length = 0;

    private Node<String, V> head;
    private Node<String, V> end;

    public LruCache(int size) {
        this.size = size;
        this.head = new Node(null, "head");
        this.end = new Node(null, "end");
    }

    public void put(String key, V value) {
        if (head.next == null) {
            Node node = new Node(key, value);
            // 当前无任何节点的情况，则直接将当前数据放入到双向队列中
            head.next = node;
            node.pre = head;
            node.next = end;
            end.pre = node;

            length++;
        } else {
            Node curNode = head.next;

            boolean isExist = false;

            while (curNode != null && curNode.key != null) {
                if (curNode.key.equals(key)) {
                    curNode.value = value;
                    // 当数据已存在时，则将当前节点移到开始位置
                    curNode.next = head.next;
                    head.next.pre = curNode;
                    curNode.pre = head;
                    head.next = curNode;
                    isExist = true;
                    break;
                }
                curNode = curNode.next;
            }
            // 新增的情况
            if (!isExist) {
                if (length + 1 > size) {
                    // 如果超出了队列大小，则需要将新增节点放到队列头部，并移出最后一个节点
                    Node node = new Node(key, value);
                    node.next = head.next;
                    head.next.pre = node;
                    node.pre = head;
                    head.next = node;

                    Node lastNode = end.pre.pre;
                    lastNode.next = end;
                    end.pre = lastNode;
                } else {
                    // 直接将新增节点插入到头部即可
                    Node node = new Node(key, value);
                    node.next = head.next;
                    head.next.pre = node;
                    node.pre = head;
                    head.next = node;
                }
                length++;
            }
        }
        print();
    }

    public V get(String key) {
        Node<String, V> curNode = head.next;
        while (curNode != null && curNode.key != null) {
            // 查找key是否存在
            if (curNode.key.equals(key)) {
                // 将当前节点移出
                curNode.pre.next = curNode.next;
                curNode.next.pre = curNode.pre;
                //移动节点到表头
                curNode.next = head.next;
                head.next.pre = curNode;
                curNode.pre = head;
                head.next = curNode;

                print();
                return curNode.value;
            }
            curNode = curNode.next;
        }
        print();
        return null;
    }

    public void print() {
        System.out.print("当前队列：");
        Node<String, V> node = head.next;
        while (node != null && node.key != null) {
            System.out.print(" { " + node.key + " : " + node.value + " } ,");
            node = node.next;
        }
        System.out.println();
    }

}
