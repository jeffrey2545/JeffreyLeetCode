class Solution {
    public int maxOperations(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Integer num1 : map.keySet()) {
            int num1Count = map.get(num1);
            int num2 = k - num1;
            if (num2 == num1) {
                int count = num1Count / 2;
                ans = ans + count;
                map.put(num1, count);
                continue;
            }
            if (map.containsKey(num2)) {
                int num2Count = map.get(num2);
                int count = Math.min(num1Count, num2Count);
                ans = ans + count;
                map.put(num1, num1Count - count);
                map.put(num2, num2Count - count);
                continue;
            }
        }
        return ans;
    }
}