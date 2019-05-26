package seven;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorII {
    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }
        Set<ParentTreeNode> dieList = new HashSet<ParentTreeNode>();
        ParentTreeNode lDie = A;
        ParentTreeNode rDie = B;
        while (lDie != null || rDie != null) {
            if (dieList.contains(lDie)) return lDie;
            if (dieList.contains(rDie)) return rDie;
            dieList.add(lDie);
            dieList.add(rDie);
            lDie = lDie.parent;
            rDie = rDie.parent;
            if (lDie == rDie) {
                return lDie;
            }
        }
        return root;
    }
}
