package nine;

import java.util.*;

public class GraphValidTree {
    // 如果一个图可以变成树，需要满足条件：1，为连通图，2，图中没有环
    // 想象一开始这个图只有顶点，没有边，我们来一条一条的添加边。
    // 每遇到一条边，判断这边的两个端点是否在同一个集合里？集合的property:表示一个连通分量，里面的任意两点有且只有一条路径可达
    // 在的话，表示有环：因为两个点在一个集合里就表示这两个点已经有一条路径了，现在再加一条路径，必然构成环。
    // 不在的话，表示不构成环，我们应该合并这两个集合：因为加上这条边，两个集合就被连起来了，合并成了一个集合
    // 告诉小孩别吃粑粑，小孩听不懂人话，还以为你故意和他做对呢，跟你生气，偏吃粑粑，使劲吃粑粑，呵呵
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0 || edges.length != n - 1) return false;
        int[] parents = new int[n];
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
        int root_a, root_b;
        for (int[] edge : edges) {
            root_a = find(parents, edge[0]);
            root_b = find(parents, edge[1]);
            if (root_a == root_b) return false;
            parents[root_b] = root_a;
        }
        return true;
    }

    public int find(int[] parents, int target) {
        if (parents[target] == target) return target;
        return parents[target] = find(parents, parents[target]);
    }
}
