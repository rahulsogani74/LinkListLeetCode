import java.util.*;
public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    private Map<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node last;
    private int capacity;
    public LRUCache(final int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        last = new Node(0, 0);
        head.next = last;
        last.prev = head;
    }
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        insert(node);
        return node.value;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(last.prev);
        }
        insert(new Node(key, value));
    }
    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(6);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 4);
        cache.put(5, 9);
        cache.put(4, 1);
        cache.put(8, 7);
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
        cache.put(7, 3);
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
        System.out.println(cache.get(7));
    }

}
