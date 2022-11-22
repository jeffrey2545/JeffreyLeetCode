class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                if (map.containsKey(sum)) {
                    int count = map.get(sum);
                    map.replace(sum, count, count+1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        int result = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int target = 0 - (num3 + num4);
                if (map.containsKey(target)) {
                    result = result + map.get(target);
                }
            }
        }
        return result;
    }
}