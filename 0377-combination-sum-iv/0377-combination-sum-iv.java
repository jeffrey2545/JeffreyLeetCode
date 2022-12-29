class Solution {
    public int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        Arrays.sort(nums);
        int result = dfs(nums, target);
        // System.out.println(memo[target]);
        return result;
    }
    
    public int dfs(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (memo[target] != -1) {
            // System.out.println("target:"+target);
            // System.out.println("memo[target]:"+memo[target]);
            return memo[target];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (target - num >= 0) {
                result = result + dfs(nums, target - num);
            } else {
                break;
            }
        }
        
        memo[target] = result;
        // System.out.println("target:"+target);
        // System.out.println("memo[target]:"+memo[target]);
        return result;
    }
}