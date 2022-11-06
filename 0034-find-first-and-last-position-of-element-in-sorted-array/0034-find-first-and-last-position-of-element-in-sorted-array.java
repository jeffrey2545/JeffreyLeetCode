class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums.length == 0) {
            return result;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // System.out.println("right:" + right + " nums[right]:" + nums[right] + " left:" + left +" nums[left]:" + nums[left]);
        if (nums[right] == target) {
            result[1] = right;
        } else {
            if (nums[left] == target) {
                result[1] = left;
            } else {
                return result;
            }
        }
        // if (nums[right] == target) {
        //     result[1] = right;
        // } else if (nums[left] == target) {
        //     result[1] = left;
        // } else {
        //     return result;
        // }
        
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // System.out.println("right:" + right + " nums[right]:" + nums[right] + " left:" + left +" nums[left]:" + nums[left]);
        if (nums[left] == target) {
            result[0] = left;
        } else {
            if (nums[right] == target) {
                result[0] = right;
            } else {
                return result;
            }
        }
        // if (nums[left] == target) {
        //     result[0] = left;
        // } else if (nums[right] == target) {
        //     result[0] = right;
        // } else {
        //     return result;
        // }

        Arrays.sort(result);
        return result;
    }
}