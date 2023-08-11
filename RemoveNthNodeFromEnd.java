public class RemoveNthNodeFromEnd {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n-- > 0) fast = fast.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == null || slow.next == null) return null;
        else if (slow == head && fast == null) head = head.next;
        else slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        int k = 2;
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();
        head = solution.removeNthFromEnd(head, k);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
