package six;

public class FlattenBinaryTreetoLinkedList {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    private TreeNode qianyigeNode = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null){
            return;
        }
        if (qianyigeNode != null){
            qianyigeNode.left = null;
            qianyigeNode.right = root;
            // 右儿子指针变成链表的next
        }
        qianyigeNode = root;
        TreeNode zuo = root.left;
        TreeNode you = root.right;
        flatten(zuo);
        flatten(you);
    }
}
