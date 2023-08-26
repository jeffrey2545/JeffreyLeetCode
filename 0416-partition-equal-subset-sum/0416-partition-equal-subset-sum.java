class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total = total + num;
        }
        if (total % 2 != 0) {
            return false;
        }
        int half = total / 2;
        Boolean[][] memo = new Boolean[nums.length + 1][half + 1];
        return dfs(half, 0, nums, memo);
    }
    
    public boolean dfs(int curr, int index, int[] nums, Boolean[][] memo) {
        if (curr == 0) {
            return true;
        }
        if (curr < 0 || index >= nums.length) {
            return false;
        }
        
        if (memo[index][curr] != null) {
            return memo[index][curr];
        }
        boolean result = dfs(curr - nums[index], index + 1, nums, memo) || dfs(curr, index + 1, nums, memo);
        memo[index][curr] = result;
        return result;
    }
}