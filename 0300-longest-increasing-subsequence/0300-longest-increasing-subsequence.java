class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int left = nums.length - 2; left >= 0; left--) {
            for (int right = left + 1; right < nums.length; right++) {
                if (nums[right] > nums[left]) {
                    dp[left] = Math.max(dp[left], dp[right] + 1);
                }
            }
        }
        
        int ans = 1;
        for (int result : dp) {
            ans = Math.max(ans, result);
        }
        return ans;
    }
}