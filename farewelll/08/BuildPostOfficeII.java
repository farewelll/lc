package eight;

import java.util.LinkedList;
import java.util.Queue;

public class BuildPostOfficeII {
    int[] deltaX = {-1, 0, 1, 0};
    int[] deltaY = {0, 1, 0, -1};
    int m = 0, n = 0;

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int[][] totalDistance = new int[m][n];
        int step = 0, res = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    res = bfs(grid, i, j, step, totalDistance);
                    step--;
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int bfs(int[][] grid, int x, int y, int step, int[][] totalDistance) {
        int res = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * n + y);

        int curDis = 0;
        while (!queue.isEmpty()) {
            int l = queue.size();
            curDis++;
            while (l-- != 0) {
                int t = queue.poll();
                x = t / n;
                y = t % n;

                for (int i = 0; i < 4; ++i) {
                    int _x = x + deltaX[i], _y = y + deltaY[i];
                    if (_x >= 0 && _x < m && _y >= 0 && _y < n && grid[_x][_y] == step) {
                        queue.offer(_x * n + _y);
                        totalDistance[_x][_y] += curDis;
                        grid[_x][_y]--;
                        res = Math.min(res, totalDistance[_x][_y]);
                    }
                }
            }
        }
        return res;
    }
}
