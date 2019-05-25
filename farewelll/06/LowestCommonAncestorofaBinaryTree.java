package six;

public class LowestCommonAncestorofaBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null){
            return null;
        }
        if(root == A || root == B){
            // 找到给定节点
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left ,A ,B);
        TreeNode r = lowestCommonAncestor(root.right, A ,B);
        if (l != null && r != null){
            return root;
            // 两边都有给定节点，返回当前节点
        } else  if (l != null){
            return l;
            // 左边不为空，返回左边。
        } else if (r != null){
            return r;
            // 右边不为空，返回右边。
        } else {
            return null;
            // 找不到，拉到了
        }
    }
}
