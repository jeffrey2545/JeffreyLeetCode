class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//fewest make up number
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        for (int currAmount = 1; currAmount <= amount; currAmount++) {
            for (int coin : coins) {
                if (currAmount - coin < 0) {
                    continue;
                }
                dp[currAmount] = Math.min(dp[currAmount - coin] + 1, dp[currAmount]);
            }
        }
        
        if (dp[amount] == 100000) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}