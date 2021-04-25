package code.lru;

public class Node<K, V> {
    K key;
    V value;
    Node<K, V> pre;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Node() {
    }
}
