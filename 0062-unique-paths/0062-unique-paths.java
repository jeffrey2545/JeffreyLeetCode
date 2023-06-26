class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[n][m];
        for (int x = 0; x < m; x++) {
            memo[0][x] = 1;
        }
        for (int y = 0; y < n; y++) {
            memo[y][0] = 1;
        }
        
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                memo[y][x] = memo[y - 1][x] + memo[y][x - 1];
            }
        }
        
        return memo[n - 1][m - 1];
    }
}