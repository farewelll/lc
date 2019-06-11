package twentythree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniquePathsIII {
    public int uniqueWeightedPaths(int[][] grid) {
        // write your codes here
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        dp.put(0, new HashSet<Integer>());
        dp.get(0).add(grid[0][0]);
        for(int i = 1; i < m; i++){
            int cur = i * n;
            int prev = (i-1) * n;
            dp.put(cur, new HashSet<Integer>());
            for(int dis: dp.get(prev)){
                dp.get(cur).add(dis + grid[i][0]);
            }
        }
        for(int j = 1; j < n; j++){
            int cur = j;
            int prev = j - 1;
            dp.put(cur, new HashSet<Integer>());
            for(int dis: dp.get(prev)){
                dp.get(cur).add(dis + grid[0][j]);
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int cur = i * n + j;
                int left = i * n + j - 1;
                int up = (i - 1) * n + j;
                dp.put(cur, new HashSet<Integer>());
                for(int dis: dp.get(left)){
                    dp.get(cur).add(dis+grid[i][j]);
                }
                for(int dis: dp.get(up)){
                    dp.get(cur).add(dis+grid[i][j]);
                }
            }
        }
        int res = 0;
        int index = (m-1)*n + n-1;
        for(int dis: dp.get(index)){
            res += dis;
        }
        return res;
    }
}
