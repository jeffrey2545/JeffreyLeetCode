class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left = 0, right;
        long sum = 0;
        int result = 1;
        Arrays.sort(nums);
        for (right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum + k < (right - left + 1) * nums[right]) {
                sum = sum - nums[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}