package six;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> zhan = new Stack<>();
        List<Integer> data = new ArrayList<>();
        if (root == null){
            return data;
        }
        zhan.push(root);

        TreeNode qian = null;
        TreeNode current = root;
        while(!zhan.isEmpty()){
            current = zhan.peek();
            if (qian == null || qian.left ==current || qian.right == current){
                if (current.left != null){
                    zhan.push(current.left);
                }
                else if (current.right != null){
                    zhan.push(current.right);
                }
            }
            else if (current.left == qian){
                if (current.right != null){
                    zhan.push(current.right);
                }
            }
            else {
                data.add(current.val);
                zhan.pop();
            }
            qian = current;
        }
        return data;
    }
}
