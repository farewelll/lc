package five;

public class BinaryTreeLongestConsecutiveSequence {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int longestConsecutive(TreeNode root) {
        // write your code here
        return findLongest(root , null , 0);
        // 开始没爹 , 长度为0.
    }
    private int findLongest(TreeNode curNode, TreeNode curNodeDie, int lengthWithoutRoot) {
        if (curNode == null) {
            return 0;
        }

        int length = 0;
        if(curNodeDie != null && curNodeDie.val + 1 == curNode.val){
            // 如果当前节点的爹不是空 而且爹的val值加1等于儿子val，长度加一。
            length = lengthWithoutRoot + 1;
        } else {
            // 如果爹和儿子val值不符合条件，重置为1.
            length = 1;
        }
        int left = findLongest(curNode.left, curNode, length);
        int right = findLongest(curNode.right, curNode, length);
        return Math.max(length, Math.max(left, right));
    }
}
