package seven;

public class LowestCommonAncestorIII {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    private boolean judgeExitA = false;
    private boolean judegExitB = false;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        TreeNode jud = judge(root , A ,B);
        if (judegExitB && judgeExitA){
            return jud;
        } else {
            return null;
        }
    }
    public TreeNode judge (TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return root;
        }
        TreeNode l = judge(root.left ,A ,B);
        TreeNode r = judge(root.right, A ,B);
        if (root == A || root == B){
            if (root == A){
                judgeExitA = true;
            }
            if (root == B){
                judegExitB =true;
            }
            return root;
        }
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
