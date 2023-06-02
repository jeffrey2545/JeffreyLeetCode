class Solution {
    public String mergeAlternately(String word1, String word2) {
        int pos1 = 0, pos2 = 0;
        boolean change = true;
        StringBuilder result = new StringBuilder();
        while (pos1 < word1.length() && pos2 < word2.length()) {
            if (change) {
                result.append(word1.charAt(pos1));
                pos1++;
                change = false;
            } else {
                result.append(word2.charAt(pos2));
                pos2++;
                change = true;
            }
        }
        if (pos1 < word1.length()) {
            while (pos1 < word1.length()) {
                result.append(word1.charAt(pos1));
                pos1++;
            }
        } else {
            while (pos2 < word2.length()) {
                result.append(word2.charAt(pos2));
                pos2++;
            }
        }
        return result.toString();
    }
}