class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            String subS2 = "";
            if (i == s2.length() - s1.length()) {
                subS2 = s2.substring(i);
            } else {
                subS2 = s2.substring(i, i + s1.length() + 1);
            }

            if (anagram(s1, subS2)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean anagram(String s1, String s2) {
        int[] count1 = new int[123];
        Arrays.fill(count1, 0);
        int[] count2 = new int[123];
        Arrays.fill(count2, 0);
        
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            count1[s1.charAt(i)]++;
            count2[s2.charAt(i)]++;
        }
        
        for (int i = 97; i < 123; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        
        return true;
    }
}