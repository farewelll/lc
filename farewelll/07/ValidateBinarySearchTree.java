package seven;

public class ValidateBinarySearchTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    private TreeNode cur = null;

    public boolean isValidBST(TreeNode root) {
        // write your code here
         return judge(root);
    }
    // 中序遍历各个节点。
    public boolean judge(TreeNode node){
        if (node == null){
            return true;
        }
        if (!judge(node.left)) {
            return false;
        }
        if (cur != null && node.val <= cur.val){
            return false;
        }
        cur = node;
        if (!judge(node.right)){
            return false;
        }
        return true;
    }
}
