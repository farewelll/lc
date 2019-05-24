package five;


public class BalancedBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (maxDepth(root) == -1){
            return false;
        } else {
            return true;
        }
    }
    private int maxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
