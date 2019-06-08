package twenty;

import java.util.List;

public class MergeKSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
  }
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() ==0){
            return null;
        }
        return merge(lists , 0 , lists.size() - 1);
    }
    public ListNode merge(List<ListNode> listNodes , int begin , int end){
        if (begin == end){
            return listNodes.get(begin);
        }
        int mid = (begin+end) / 2;
        ListNode zuo = merge(listNodes , begin , mid);
        ListNode you = merge(listNodes , mid+ 1 , end);
        return conpaction(zuo , you);
    }
    private ListNode conpaction(ListNode zuo , ListNode you){
        ListNode newNode = new ListNode(0);
        ListNode cur = newNode;
        while (zuo != null && you != null){
            if (zuo.val < you.val) {
                cur.next = zuo;
                cur = zuo;
                zuo = zuo.next;
            } else {
                cur.next = you;
                cur = you;
                you = you.next;
            }
        }
        if (zuo != null){
            cur.next = zuo;
        }
        if (you != null){
            cur.next = you;
        }
        return newNode.next;
    }
}
