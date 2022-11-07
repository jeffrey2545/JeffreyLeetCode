class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[i] > nums[k]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}