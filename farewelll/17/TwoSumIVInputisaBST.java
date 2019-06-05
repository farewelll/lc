package seventeen;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIVInputisaBST {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    int[] data = new int[2];
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if (root == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        inorder(root, n, map);
        return data;
    }

    private void inorder(TreeNode root, int n, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        inorder(root.left, n, map);
        if (map.containsKey(root.val)) {
            data[0] = map.get(root.val);
            data[1] = root.val;
        } else {
            map.put(n - root.val, root.val);
        }
        inorder(root.right, n, map);
    }
}
