class Solution {
    public int maximumLength(int[] nums) {
        int maxCount = 1;
        // build map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.containsKey(1)) {
            int one = map.get(1);
            if (one % 2 == 0) {
                one = one - 1;
            }
            maxCount = Math.max(maxCount, one);
            map.remove(1);
        }
        // iterate the key of map
        for (Integer key : map.keySet()) {
            int currCount = 1;
            int x = key;
            while (map.containsKey(x * x) && map.get(x) >= 2) {
                currCount = currCount + 2;
                x = x * x;
            }
            maxCount = Math.max(maxCount, currCount);
        }
        
        return maxCount;
    }
}