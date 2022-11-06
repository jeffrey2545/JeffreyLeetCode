class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        
        int start = 0;
        int end = nums.length - 1;
        int minIndex = 0;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            minIndex = end;
        } else {
            minIndex = start;
        }
        int maxIndex = 0;
        if (minIndex == 0) {
            maxIndex = nums.length - 1;
        } else {
            maxIndex = minIndex - 1;
        }
        if (target > nums[maxIndex] || target < nums[minIndex]) {
            return -1;
        }
        
        // System.out.println(minIndex);
        
        if (target == nums[minIndex]) {
            return minIndex;
        }
        if (target > nums[nums.length - 1]) {
            start = 0;
            end = minIndex - 1;
        } else {
            start = minIndex;
            end = nums.length - 1;
        }
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}