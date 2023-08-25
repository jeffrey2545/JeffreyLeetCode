class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if ((nums[mid] == nums[mid - 1] && mid % 2 == 1) || (nums[mid] == nums[mid + 1] && mid % 2 == 0))  { // right
                start = mid;
            } else { // left
                end = mid;
            }
        }
        
        if (start == 0) {
            return nums[start];
        }
        if (end == nums.length - 1) {
            return nums[end];
        }
        if (nums[start] == nums[start + 1] || nums[start] == nums[start - 1]) {
            return nums[end];
        } else {
            return nums[start];
        }
    }
}