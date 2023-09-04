class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int curr = 1; curr < nums.length; curr++) {
            for (int pre = 0; pre < curr; pre++) {
                if (dp[pre] != Integer.MAX_VALUE && nums[pre] + pre >= curr) {
                    dp[curr] = Math.min(dp[curr], dp[pre] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }
}