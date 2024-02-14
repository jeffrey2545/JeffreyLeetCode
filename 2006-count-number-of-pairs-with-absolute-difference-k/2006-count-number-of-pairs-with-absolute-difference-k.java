class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();// num, count
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (map.containsKey(num + k)) {
                int count = map.get(Math.abs(num + k));
                ans = ans + count;
            }
            if (map.containsKey(num - k)) {
                int count = map.get(Math.abs(num - k));
                ans = ans + count;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}