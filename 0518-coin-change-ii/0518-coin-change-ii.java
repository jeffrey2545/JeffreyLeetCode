class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(amount, coins, 0, memo);
    }
    
    public int dfs(int amount, int[] coins, int start, int[][] memo) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || start == coins.length) {
            return 0;
        }
        
        if (memo[start][amount] != -1) {
            return memo[start][amount];
        }
        
        int num = 0;
        for (int i = start; i < coins.length; i++) {
            num += dfs(amount - coins[i], coins, i, memo);  // Note the change here: passing 'i' instead of starting from 0
        }
        
        memo[start][amount] = num;
        return num;
    }
}
