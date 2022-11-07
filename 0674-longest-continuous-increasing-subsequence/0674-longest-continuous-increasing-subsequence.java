class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int count = 1;
            for (int k = i + 1; k < nums.length; k++) {
                int second = nums[k];
                if (second > first) {
                    first = second;
                    count++;
                } else {
                    break;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}