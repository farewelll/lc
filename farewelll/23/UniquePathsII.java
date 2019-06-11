package twentythree;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 0 || n == 0){
            return 0;
        }
        int [][] arr = new int[m][n];
        for (int i = 0 ; i < m ; i ++){
            if (obstacleGrid[i][0] != 1){
                arr[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0 ; i < n ; i ++){
            if (obstacleGrid[0][i] != 1){
                arr[0][i] = 1;
            }else {
                break;
            }
        }
        for (int i = 1 ; i < m ; i ++){
            for (int j = 1 ; j < n ; j ++){
                if (obstacleGrid[i][j] != 1){
                    arr [i][j] = arr[i - 1][j]+ arr[i][j -1];
                } else {
                    arr[i][j] = 0;
                }

            }
        }
        return arr[m - 1][n - 1];
    }
}
