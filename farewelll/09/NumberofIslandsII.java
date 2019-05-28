package nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofIslandsII {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        ArrayList<Integer> result = new ArrayList<>();
        if (operators == null || operators.length < 1) {
            return result;
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;
        for (Point p : operators) {
            count++;
            int idx = n * p.x + p.y;

            if (parent[idx] == -1) {
                parent[idx] = idx;
            }

            for (int k = 0; k < 4; k++) {
                int x = p.x + dx[k];
                int y = p.y + dy[k];

                int idxNeighbor = n * x + y;

                if (x >= 0 && x < m && y >= 0 && y < n && parent[idxNeighbor] != -1) {
                    int tmp = getParent(parent, idxNeighbor);

                    if (parent[tmp] != idx) {
                        parent[tmp] = idx;
                        count--;
                    }
                }
            }

            result.add(count);
        }

        return result;
    }

    private int getParent(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }

        return i;
    }
}
