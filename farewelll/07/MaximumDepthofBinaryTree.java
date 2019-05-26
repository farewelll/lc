package seven;

public class MaximumDepthofBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null){
            return 0;
        }
        int lMax = maxDepth(root.left);
        int rMax = maxDepth(root.right);
        return Math.max(lMax , rMax) + 1;
    }
}
