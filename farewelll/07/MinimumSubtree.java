package seven;

public class MinimumSubtree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    private int curSum = 1000000000;
    private TreeNode curNode = null;
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        calSum(root);
        return curNode;
    }
    public int calSum(TreeNode node){
        if (node == null){
            return 0;
        }
        int sum = calSum(node.left) + calSum(node.right) + node.val;
        if (sum < curSum){
            curSum = sum;
            curNode = node;
        }
        return sum;
    }
}
