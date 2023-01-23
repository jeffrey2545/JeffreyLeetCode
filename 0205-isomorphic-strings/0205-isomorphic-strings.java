class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sStore = new int[130];
        Arrays.fill(sStore, 0);
        Map<Character, Character> map = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            sStore[ch] = sStore[ch] + 1;
        }
        
        // int sum2 = 0;
        // for (int num : sStore) {
        //     sum2 = sum2 + num;
        // }
        // System.out.println(sum2);
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (!map.containsKey(tArr[i])) {
                if (map.containsValue(sArr[i])) {
                    return false;
                }
                map.put(tArr[i], sArr[i]);
            }
            if (map.get(tArr[i]) != sArr[i]) {
                return false;
            }
            sStore[map.get(tArr[i])] = sStore[map.get(tArr[i])] -1;
        }
        
        for (int num : sStore) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}