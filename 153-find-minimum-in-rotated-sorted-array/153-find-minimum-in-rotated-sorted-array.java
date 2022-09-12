class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int startPoint = 0;
        int endPoint = nums.length - 1;
        int end = nums[endPoint];
        while (startPoint + 1 < endPoint) {
            int midPoint = (startPoint + endPoint) / 2;
            int mid = nums[midPoint];
            if (mid > end) {
                startPoint = midPoint;
            }
            if (mid < end) {
                endPoint = midPoint;
                end = mid;
            }
        }

        return Math.min(nums[startPoint], nums[endPoint]);
    }
}