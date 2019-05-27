package eight;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        String str = "{" + String.valueOf(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                str = str +",#";
            } else {
                str = str + "," + String.valueOf(queue.get(i).val);
            }
        }
        str = str + "}";
        return str;
    }
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        String[] ele = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(ele[0]));
        queue.add(root);
        int index = 0;
        boolean flag = true;
        for (int i = 1; i < ele.length; i++) {
            if (!ele[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(ele[i]));
                if (flag) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!flag) {
                index++;
            }
            flag = !flag;
        }
        return root;
    }
}
