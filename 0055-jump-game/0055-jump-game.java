class Solution {
    public boolean canJump(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        Arrays.fill(memo, false);
        memo[0] = true;
        
        for (int curr = 1; curr < nums.length; curr++) {
            for (int pre = 0; pre < curr; pre++) {
                if (memo[pre] && nums[pre] + pre >= curr) {
                    memo[curr] = true;
                    break;
                }
            }
        }
        
        return memo[nums.length - 1];
    }
}