class Solution {
    public int maxProduct(int[] nums) {
        int maxDP = nums[0];
        int minDP = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int tmpMaxDP = Math.max(nums[i], Math.max(maxDP * nums[i], minDP * nums[i]));
            int tmpMinDP = Math.min(nums[i], Math.min(maxDP * nums[i], minDP * nums[i]));
            
            maxDP = tmpMaxDP;
            minDP = tmpMinDP;
            
            result = Math.max(result, maxDP);
        }
        
        return result;
    }
}