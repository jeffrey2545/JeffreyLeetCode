class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int one = m - 1;
        int two = n - 1;
        int index = nums1.length - 1;
        while (index >= 0 && one >= 0 && two >= 0) {
            if (nums1[one] > nums2[two]) {
                nums1[index] = nums1[one];
                one--;
            } else {
                nums1[index] = nums2[two];
                two--;
            }
            index--;
        }
        if (two >= 0) {
            while (index >= 0 && two >= 0) {
                nums1[index] = nums2[two];
                two--;
                index--;
            }
        }
    }
}