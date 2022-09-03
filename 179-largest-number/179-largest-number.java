class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        int[] tmpp = new int[nums.length];
        split(nums, 0, nums.length - 1, tmpp);
        if (nums[0] == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (int q = 0; q < nums.length; q++) {
            result.append(String.valueOf(nums[q]));
        }
        return result.toString();
    }
    public void split(int[] arr, int start, int end, int[] tmp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;

        split(arr, start, mid, tmp);
        split(arr, mid + 1, end, tmp);
        merge(arr, start, mid, end, tmp);
    }

    public void merge(int[] arr, int start, int mid, int end, int[] tmp) {
        int left = start;
        int right = mid + 1;

        for (int i = 0; i < end - start + 1; i++) {
            if (left <= mid &&(right > end || larger(arr[left], arr[right]))) {
                tmp[i] = arr[left++];
            } else {
                tmp[i] = arr[right++];
            }
        }
        for (int k = 0; k < end - start + 1; k++) {
            arr[start + k] = tmp [k]; 
        }
    }

    public boolean larger(int left, int right) {
        String leftStr = String.valueOf(left);
        String rightStr = String.valueOf(right);
        if (Long.valueOf(leftStr + rightStr) > Long.valueOf(rightStr + leftStr)){
            return true;
        } else {
            return false;
        }
    }
}