package seven;

public class MinimumDepthofBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null){
            return  0;
        }
        return min(root);
    }
    public int min (TreeNode node){
        if(node == null){
            return 100000000;
        }
        if (node.left == null && node.right == null){
            return 1;
        }
        return Math.min(min(node.left) ,min(node.right)) + 1;
    }
}
