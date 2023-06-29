class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        
        for (int left = 2; left < nums.length; left++) {
            int rob = money[left - 2] + nums[left];
            int noRob = money[left - 1];
            money[left] = Math.max(rob, noRob);
        }
        
        return money[nums.length - 1];
    }
}