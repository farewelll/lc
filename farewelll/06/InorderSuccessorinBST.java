package six;

public class InorderSuccessorinBST {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null){
            return null;
        }
        if (root.val <= p.val){
            // 在右边
            return inorderSuccessor( root.right ,p);
        } else {
            // 在左边
            if (inorderSuccessor(root.left , p) != null){
                return inorderSuccessor(root.left  ,p);
            } else {
                return root;
            }
        }
    }
}
