package six;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> zhan = new Stack<>();
        List<Integer> data = new ArrayList<>();
        if (root == null){
            return data;
        }
        zhan.push(root);
        while (!zhan.isEmpty()){
            TreeNode current = zhan.pop();
            data.add(current.val);
            if (current.right != null){
                zhan.push(current.right);
            }
            if (current.left != null){
                zhan.push(current.left);
            }
        }
        return data;
    }
}
