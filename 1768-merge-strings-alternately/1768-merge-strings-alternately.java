class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i1 = 0;
        int i2 = 0;
        boolean flip = true;
        StringBuilder ans = new StringBuilder();
        
        while (i1 < word1.length() && i2 < word2.length()) {
            if (flip) {
                ans.append(word1.charAt(i1));
                i1++;
                flip = false;
            } else {
                ans.append(word2.charAt(i2));
                i2++;
                flip = true;
            }
        }
        
        if (i1 < word1.length()) {
            ans.append(word1.substring(i1, word1.length()));
        } else {
            ans.append(word2.substring(i2, word2.length()));
        }
        
        return ans.toString();
    }
}