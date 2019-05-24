package five;

public class BinaryTreeLongestConsecutiveSequenceII {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public int longestConsecutive2(TreeNode root) {
        // write your code here
        if (root == null){
            return 0;
        }
        int maxRoot = findLongest2(root , 1) +  findLongest2(root ,-1) + 1;
        return Math.max(maxRoot , Math.max(longestConsecutive2(root.left),longestConsecutive2(root.right)));
    }
    private int findLongest2(TreeNode curNode,int dif) {
        if (curNode == null) {
            return 0;
        }
        int left = 0 ;
        int right = 0;
        if (curNode.left != null && curNode.val - curNode.left.val ==dif){
            left = 1 + findLongest2(curNode.left , dif);
        }
        if (curNode.right != null && curNode.val - curNode.right.val ==dif){
            right = 1 + findLongest2(curNode.right , dif);
        }
        return Math.max(left, right);
    }
}
