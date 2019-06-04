package fourteen;

public class MergeTwoSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode newList = new ListNode(0);
        ListNode current = newList;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null){
            current.next = l1;
        } if (l2 != null){
            current.next = l2;
        }
        return newList.next;
    }
}