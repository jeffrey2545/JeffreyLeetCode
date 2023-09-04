class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        
        while (!map.isEmpty()) {
            int start = map.firstKey();
            for (int key = start; key < start + groupSize; key++) {
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