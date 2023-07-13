class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else if (nums[mid] < nums[nums.length - 1]) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        
        int leftSide = bs(nums, target, 0, left - 1);
        if (leftSide != -1) {
            return leftSide;
        }
        return bs(nums, target, left, nums.length - 1);
    }
    private int bs(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}