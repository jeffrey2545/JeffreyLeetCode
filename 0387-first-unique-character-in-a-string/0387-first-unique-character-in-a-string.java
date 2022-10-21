class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            char ch = sArray[i];
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.replace(ch, count, count + 1);
            } else {
                map.put(ch, 1);
            }
        }
        
        for (int i = 0; i < sArray.length; i++) {
            char ch = sArray[i];
            if (map.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}