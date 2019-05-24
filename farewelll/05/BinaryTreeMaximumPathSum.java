package five;

public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class ReturnType {
        int maxSingle;
        int max;

        ReturnType(int maxSingle, int max) {
            this.max = max;
            this.maxSingle = maxSingle;
        }
    }

    public int maxPathSum(TreeNode root) {
        return dfs(root).max;
    }

    public ReturnType dfs(TreeNode root) {
        ReturnType ret = new ReturnType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        if (root == null) {
            return ret;
        }

        ReturnType left = dfs(root.left);
        ReturnType right = dfs(root.right);

        int cross = root.val;
        cross += Math.max(0, left.maxSingle);
        cross += Math.max(0, right.maxSingle);
        int maxSingle = Math.max(left.maxSingle, right.maxSingle);

        maxSingle = Math.max(maxSingle, 0);
        maxSingle += root.val;

        ret.maxSingle = maxSingle;
        ret.max = Math.max(right.max, left.max);
        ret.max = Math.max(ret.max, cross);

        return ret;
    }
}
