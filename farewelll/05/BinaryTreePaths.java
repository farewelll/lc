package five;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> paths = new ArrayList<>();
        if (root == null){
            return paths;
        }
        List<String> leftP = binaryTreePaths(root.left);
        List<String> rightP = binaryTreePaths(root.right);
        for (String lp : leftP){
            paths.add(root.val + "->" + lp);
        }
        for (String  rp : rightP){
            paths.add(root.val + "->" + rp);
        }
        if (paths.size() ==0){
            paths.add(String.valueOf(root.val));
        }
        return paths;
    }
}
