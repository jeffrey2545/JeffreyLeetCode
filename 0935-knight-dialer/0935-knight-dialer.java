class Solution {
    int[][] movement = {
        {4, 6},
        {6, 8},
        {7, 9},
        {4, 8},
        {3, 9, 0},
        {},
        {1, 7, 0},
        {2, 6},
        {1, 3},
        {4, 2},
    };
    int[][] memo;
    int MOD = (int) 1e9 + 7;
    
    public int knightDialer(int n) {
        memo = new int[n + 1][10];
        int ans = 0;
        for (int num = 0; num < 10; num++) {
            ans = (ans + dfs(n - 1, num)) % MOD;
        }
        return ans;
    }
    
    public int dfs(int remain, int num) {
        if (remain == 0) {
            return 1;
        }
        
        if (memo[remain][num] != 0) {
            return memo[remain][num];
        }
        
        int count = 0;
        for (int next : movement[num]) {
            count = (count + dfs(remain - 1, next)) % MOD;
        }
        memo[remain][num] = count;
        return count;
    }
}