class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        // int[][][] memo = new int[multipliers.length + 1][nums.length + 1][nums.length + 1];
        // for (int[][] arrs : memo) {
        //     for (int[] arr : arrs) {
        //         Arrays.fill(arr, -1);
        //     }
        // }
        Map<String, Integer> memo = new HashMap<>();
        
        return dfs(nums, multipliers, memo, 0, 0, nums.length - 1);
    }
    
    public int dfs(int[] nums, int[] multipliers, Map<String, Integer> memo, int index, int left, int right) {
        if (index == multipliers.length || left >= nums.length || right < 0) {
            return 0;
        }
        
        // if (memo[index][left][right] != -1) {
        //     return memo[index][left][right];
        // }
        String key = String.valueOf(index) + String.valueOf(left) + String.valueOf(right);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int pickLeft = nums[left] * multipliers[index] + dfs(nums, multipliers, memo, index + 1, left + 1, right);
        int pickRight = nums[right] * multipliers[index] + dfs(nums, multipliers, memo, index + 1, left, right - 1);
        // memo[index][left][right] = Math.max(pickLeft, pickRight);
        memo.put(key, Math.max(pickLeft, pickRight));
        return memo.get(key);
    }
}