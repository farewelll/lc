package twenty;

import eighteen.NestedInteger;

import java.util.List;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        return dfs(nestedList, 1);
    }

    public int dfs(List<NestedInteger> list, int dep) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (NestedInteger l : list) {
            if (l.isInteger()) {
                sum = sum + l.getInteger() * dep;
            } else {
                sum = sum + dfs(l.getList(), dep + 1);
            }
        }
        return sum;
    }
}
