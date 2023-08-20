class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rowSize = matrix.length, colSize = matrix[0].length;
        int[][] dp = new int[rowSize][colSize];
        for (int col = 0; col < colSize; col++) {
            dp[0][col] = matrix[0][col];
        }
        for (int row = 1; row < rowSize; row++) {
            Arrays.fill(dp[row], Integer.MAX_VALUE);
        }
        
        for (int row = 1; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (col - 1 >= 0) {
                    dp[row][col] = Math.min(dp[row][col], dp[row - 1][col - 1] + matrix[row][col]);
                }
                if (col + 1 < colSize) {
                    dp[row][col] = Math.min(dp[row][col], dp[row - 1][col + 1] + matrix[row][col]);
                }
                dp[row][col] = Math.min(dp[row][col], dp[row - 1][col] + matrix[row][col]);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int lastRow : dp[rowSize - 1]) {
            ans = Math.min(ans, lastRow);
        }
        return ans;
    }
}