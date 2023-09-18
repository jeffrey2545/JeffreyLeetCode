class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == target) {
                return true;
            }
            if (nums[end] == target) {
                return true;
            }
            
            if (nums[mid] > nums[end]) {// left side
                if (nums[mid] > target && nums[start] < target) {
                    end = mid;
                    continue;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[end]) {// right side
                if (nums[mid] < target && nums[end] > target) {
                    start = mid;
                    continue;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }
        
        if (nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }
}