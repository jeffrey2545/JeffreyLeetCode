class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, target, memo);
    }
    
    public int dfs(int[] nums, int index, int target, HashMap<String, Integer> memo) {
        if (index == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        
        String key = index + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int plus = dfs(nums, index + 1, target - nums[index], memo);
        int minus = dfs(nums, index + 1, target + nums[index], memo);
        
        memo.put(key, plus + minus);
        return plus + minus;
    }
}