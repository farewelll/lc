package eight;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> myList = new ArrayList<>();
        if (root == null){
            return myList;
        }
        Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) myQueue).add(root);
        boolean flag = false;
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
            if (flag == false){
                myList.add(data);
                flag = true;
            } else {
                Collections.reverse(data);
                myList.add(data);
                flag = false;
            }

        }
        return myList;
    }
}
