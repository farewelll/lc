package thirteen;

public class LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null){
            return false;
        }
        ListNode kuai = head.next;
        ListNode man = head;
        while(kuai != man){
            if (kuai == null || kuai.next == null){
                return false;
            }
            kuai = kuai.next.next;
            man = man.next;
        }
        return true;
    }
}
