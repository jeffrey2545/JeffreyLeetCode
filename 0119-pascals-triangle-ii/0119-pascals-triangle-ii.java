class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        for (int row = 0; row < rowIndex + 1; row++) {
            dp[row][row] = 1;
            dp[row][0] = 1;
        }
        
        for (int row = 2; row < rowIndex + 1; row++) {
            for (int col = 1; col < rowIndex; col++) {
                dp[row][col] = dp[row - 1][col - 1] + dp[row - 1][col];
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int num : dp[rowIndex]) {
            ans.add(num);
        }
        return ans;
    }
}