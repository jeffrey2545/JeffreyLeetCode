class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        
        int ans = Integer.MIN_VALUE;
        for (int num : dp) {
            ans = Math.max(ans, num);
        }
        
        return ans;
    }
}