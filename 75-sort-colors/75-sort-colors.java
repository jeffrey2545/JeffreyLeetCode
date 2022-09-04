class Solution {
    public void sortColors(int[] nums) {
        int[] tmp = new int[nums.length];
        split(nums, 0, nums.length - 1, tmp);
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
            if (left <= mid && (right > end || (arr[left] < arr[right]))) {
                tmp[i] = arr[left++];
            } else {
                tmp[i] = arr[right++];
            }
        }
        for (int k = 0; k < end - start + 1; k++) {
            arr[start + k] = tmp[k];
        }
    }
}