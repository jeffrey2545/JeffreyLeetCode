class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int startPoint = 0;
        int endPoint = nums.length - 1;
        while (startPoint < endPoint) {
            int midPoint = (startPoint + endPoint) / 2;
            if (nums[midPoint] > nums[endPoint]) {
                startPoint = midPoint + 1;
            } else if (nums[midPoint] < nums[endPoint]) {
                endPoint = midPoint;
            } else {
                endPoint--;
            }
        }

        return Math.min(nums[startPoint], nums[endPoint]);
    }
}