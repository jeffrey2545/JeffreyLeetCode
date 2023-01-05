class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[k] < nums[i]) {
                    if (dp[i] == dp[k] + 1) {
                        count[i] = count[k] + count[i];
                    } else if (dp[i] < dp[k] + 1) {
                        dp[i] = dp[k] + 1;
                        count[i] = count[k];
                    }
                }
            }
        }

        int result = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            int num = dp[i];
            // System.out.println("dp:" + num);
            // System.out.println("count:" + count[i]);
            if (num > max) {
                max = num;
                result = count[i];
            } else if (num == max) {
                result = result + count[i];
            }
        }
        return result;
    }
}
