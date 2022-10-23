class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        int[][] dp = new int[m][n];
        
        boolean mObstacle = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                mObstacle = true;
            }
            if (mObstacle) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        boolean nObstacle = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                nObstacle = true;
            }
            if (nObstacle) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int k = 1; k < n; k++) {
                if (obstacleGrid[i][k] == 1) {
                    dp[i][k] = 0;
                } else {
                    dp[i][k] = dp[i][k - 1] + dp[i - 1][k];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}