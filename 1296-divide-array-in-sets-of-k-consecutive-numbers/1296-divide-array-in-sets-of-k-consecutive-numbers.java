class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : nums) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        
        while (!map.isEmpty()) {
            int start = map.firstKey();
            for (int key = start; key < start + k; key++) {
                if (!map.containsKey(key)) {
                    return false;
                }
                int count = map.get(key);
                count--;
                if (count == 0) {
                    map.remove(key);
                } else {
                    map.put(key, count);
                }
            }
        }
        
        return true;
    }
}