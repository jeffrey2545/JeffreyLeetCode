class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums1 = new int[m];
        for (int i = 0; i < m; i++) {
            newNums1[i] = nums1[i];
        }
        int[] result = new int[m + n];
        int onePoint = 0, twoPoint = 0;
        
        for (int i = 0; i < m + n; i++) {
            if (twoPoint < n && (onePoint >= m || newNums1[onePoint] >= nums2[twoPoint])) {
                result[i] = nums2[twoPoint++];
            } else {
                result[i] = newNums1[onePoint++];
            }
        }
        
        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }
}