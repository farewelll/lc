package eight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> myList = new ArrayList<>();
        if (root == null){
            return myList;
        }
        Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) myQueue).add(root);
        while (!myQueue.isEmpty()){
            List<Integer> data = new ArrayList<Integer>();
            int total = myQueue.size();
            for (int i = 0 ; i < total ; i ++){
                TreeNode cur = ((LinkedList<TreeNode>) myQueue).poll();
                data.add(cur.val);
                if (cur.left != null){
                    ((LinkedList<TreeNode>) myQueue).add(cur.left);
                }
                if (cur.right != null){
                    ((LinkedList<TreeNode>) myQueue).add(cur.right);
                }
            }
            myList.add(data);
        }
        return myList;
    }
}
