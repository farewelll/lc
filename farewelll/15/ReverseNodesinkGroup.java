package fifteen;

public class ReverseNodesinkGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode newList = new ListNode(0);
        ListNode wholeTail = newList;
        ListNode wholeHead = head;
        while (head != null) {
            int tmpSize = 0;
            while (tmpSize < k - 1 && head != null) {
                tmpSize++;
                head = head.next;
            }
            if (head != null) {
                ListNode nextHead = head.next;
                head.next = null;
                ListNode tmp = reverse(wholeHead);
                wholeTail.next = tmp;
                wholeTail = wholeHead;
                wholeHead = nextHead;
                head = wholeHead;
            } else {
                wholeTail.next = wholeHead;
            }
        }
        return newList.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
