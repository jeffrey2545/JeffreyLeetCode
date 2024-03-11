class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder rest = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (order.indexOf(String.valueOf(c)) >= 0) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else {
                rest.append(c);
            }
        }
        
        StringBuilder orderInS = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                for (int i = 0; i < map.get(c); i++) {
                    orderInS.append(c);
                }
            }
        }
        return orderInS.toString() + rest.toString();
    }
}