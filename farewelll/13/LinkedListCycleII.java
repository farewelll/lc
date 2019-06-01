package thirteen;

public class LinkedListCycleII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode kuai = head.next;
        ListNode man = head;
        while (kuai != man) {
            if (kuai == null || kuai.next == null) {
                return null;
            }
            kuai = kuai.next.next;
            man = man.next;
        }
        ListNode ru = head;
        while (ru != man.next) {
            ru = ru.next;
            man = man.next;
        }
        return ru;
    }

}
