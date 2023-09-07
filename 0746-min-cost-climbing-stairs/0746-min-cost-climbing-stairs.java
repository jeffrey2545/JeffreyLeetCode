class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            int one = dp[i - 1] + cost[i - 1];
            int two = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(one, two);
        }
        return dp[dp.length - 1];
    }
}