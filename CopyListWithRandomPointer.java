import java.util.HashMap;
import java.util.Map;
public class CopyListWithRandomPointer {
    static class Node {
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
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node copiedNode = map.get(current);
            copiedNode.next = map.get(current.next);
            copiedNode.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Node copiedHead = solution.copyRandomList(head);
        Node current = copiedHead;
        while (current != null) {
            System.out.print("Value: " + current.val);
            if (current.random != null) {
                System.out.print(", Random: " + current.random.val);
            }
            System.out.println();
            current = current.next;
        }
    }
}
