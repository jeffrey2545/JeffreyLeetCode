class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> ansSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                ansSet.add(num);
            }
        }
        int[] ansArr = new int[ansSet.size()];
        int i = 0;
        for (Integer val : ansSet) {
            ansArr[i] = val;
            i++;
        }
        return ansArr;
    }
}