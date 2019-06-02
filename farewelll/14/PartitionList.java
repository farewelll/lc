package fourteen;

public class PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode lefthead = new ListNode(0);
        ListNode righthead = new ListNode(0);
        ListNode left = lefthead, right = righthead;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }

        right.next = null;
        left.next = righthead.next;
        return lefthead.next;
    }
}
