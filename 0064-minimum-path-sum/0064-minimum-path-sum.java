class Solution {
    public int minPathSum(int[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        int[][] dp = new int[rowSize][colSize];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];
        for (int row = 1; row < rowSize; row++) {
            dp[row][0] = grid[row][0] + dp[row - 1][0];
        }
        for (int col = 1; col < colSize; col++) {
            dp[0][col] = grid[0][col] + dp[0][col - 1];
        }
        
        for (int row = 1; row < rowSize; row++) {
            for (int col = 1; col < colSize; col++) {
                dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        
        return dp[rowSize - 1][colSize - 1];
    }
}