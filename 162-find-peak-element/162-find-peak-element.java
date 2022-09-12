class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        int startPoint = 0;
        int endPoint = nums.length - 1;
        while (startPoint + 1 < endPoint) {
            int midPoint = (startPoint + endPoint) / 2;
            // System.out.println(midPoint);
            int preMid = nums[midPoint - 1];
            int mid = nums[midPoint];
            int passMid = nums[midPoint + 1];
            if (mid > preMid && mid > passMid) {
                return midPoint;
            }
            if (mid > preMid && mid < passMid) {
                startPoint = midPoint;
            }
            if (mid < preMid && mid > passMid) {
                endPoint = midPoint;
            }
            if (mid < preMid && mid < passMid) {
                endPoint = midPoint;
            }
        }
        if (nums[startPoint] > nums[endPoint]) {
            return startPoint;
        } else {
            return endPoint;
        }
    }
}