package six;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertBinaryTreetoDoublyLinkedList {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }

    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        // write your code here
        Stack<TreeNode> zhan = new Stack<>();
        DoublyListNode doublyListNode = new DoublyListNode(root.val);
        DoublyListNode currentList = doublyListNode;
        if (root == null){
            return null;
        }
        while (root != null){
            zhan.push(root);
            root = root.left;
        }
        while (!zhan.isEmpty()){
            TreeNode curNode = zhan.peek();
            DoublyListNode tmp = new DoublyListNode(curNode.val);
            currentList.next = tmp;
            tmp.prev = currentList;
            currentList = tmp;
            if (curNode.right != null){
                // 右子树不为空，以当前右子树为根，根的左子树进栈.
                curNode = curNode.right;
                while(curNode != null){
                    zhan.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                // 右子树为空，弹出已经访问过的点
                curNode = zhan.pop();
                while (!zhan.isEmpty() && zhan.peek().right == curNode) {
                    curNode = zhan.pop();
                }
            }
        }
        return doublyListNode.next;
    }

}
