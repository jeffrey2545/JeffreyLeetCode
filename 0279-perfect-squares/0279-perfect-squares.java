class Solution {
    int limit;
    int[] memo;  // memoization array
    
    public int numSquares(int n) {
        limit = (int)Math.sqrt(n);
        memo = new int[n + 1];  // Initialize memoization array
        Arrays.fill(memo, -1);  // Fill with -1 to indicate not computed
        return dfs(n);
    }
    
    public int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (memo[n] != -1) {  // If already computed, return memoized value
            return memo[n];
        }
        
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i <= limit; i++) {
            if (n - (i * i) >= 0) {
                minCount = Math.min(minCount, 1 + dfs(n - (i * i)));
            }
        }
        
        memo[n] = minCount;  // Store the computed value in memoization array
        return minCount;
    }
}
