package eighteen;

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Stack {

    ListNode head;

    public Stack() {
        head = new ListNode(0);
        head.next = null;
    }

    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = head.next;
        head.next = node;
    }

    /*
     * @return: nothing
     */
    public void pop() {
        if (head.next != null) {
            head.next = head.next.next;
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        return head.next.val;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return head.next == null;
    }
}