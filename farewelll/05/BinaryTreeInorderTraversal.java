package five;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    // 栈的相关操作
    // public interface Stack<T> {
    //
    //   /**
    //    * 栈是否为空
    //    * @return
    //    */
    //   boolean isEmpty();
    //
    //   /**
    //    * data元素入栈
    //    * @param data
    //    */
    //   void push(T data);
    //
    /**
    * 返回栈顶元素,未出栈
    * @return
    */
    //T peek();
    /**
    //    * 出栈,返回栈顶元素,同时从栈中移除该元素
    //    * @return
    //    */
    //   T pop();


    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> zhan = new Stack<>();
        List<Integer> data = new ArrayList<>();
        while (root != null){
            zhan.push(root);
            root = root.left;
        }
        while (!zhan.isEmpty()){
            TreeNode curNode = zhan.peek();
            data.add(curNode.val);
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
        return data;
    }
}
