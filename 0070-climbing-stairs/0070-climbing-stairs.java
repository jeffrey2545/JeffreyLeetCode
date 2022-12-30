class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }
    
    public int dfs(int n, int[] memo) {
        if (n <= 1 && n >= 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        
        int ways1 = dfs(n - 1, memo);
        int ways2 = dfs(n - 2, memo);
        
        memo[n] = ways1 + ways2;
        return ways1 + ways2;
    }
}