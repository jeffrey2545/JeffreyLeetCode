class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] sArr = new int[123];
        Arrays.fill(sArr, 0);
        int[] tArr = new int[123];
        Arrays.fill(tArr, 0);
        
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i)]++;
            tArr[t.charAt(i)]++;
        }
        
        for (int i = 97; i < 123; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        
        return true;
    }
}