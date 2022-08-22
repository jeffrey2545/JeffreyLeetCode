class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : answers) {
            if (map.containsKey(num)) {
                map.replace(num, map.get(num), map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int rabbit = entry.getKey() + 1;
            int count = entry.getValue();
            int group = count / rabbit;
            if (count % rabbit != 0) {
                group++;
            }
            result += rabbit * group;
        }
        
        return result;
    }
}