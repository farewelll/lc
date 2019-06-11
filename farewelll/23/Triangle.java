package twentythree;

public class Triangle {
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int row = triangle.length;
        int col = triangle[row - 1].length;

        int[][] dp = new int[row][col];
        dp[0][0] = triangle[0][0];
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < row; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle[i][j];
                    continue;
                }

                if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][triangle[i - 1].length - 1] + triangle[i][j];
                    continue;
                }

                dp[i][j] = Math.min(dp[i-1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        for (int i = 0; i < triangle[row - 1].length ; i++) {
            result = Math.min(dp[row - 1][i], result);
        }

        return result;
    }
}
