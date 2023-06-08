class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        HashMap<String, Boolean> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                if (map.get(word)) {
                    result++;
                }
            } else {
                if (isSubseq(s, word)) {
                    result++;
                    map.put(word, true);
                } else {
                    map.put(word, false);
                }
            }
        }
        return result;
    }
    
    public boolean isSubseq(String target, String word) {
        int pointT = 0;
        int pointW = 0;
        while (pointT < target.length()) {
            if (target.charAt(pointT) == word.charAt(pointW)) {
                pointW++;
            }
            if (pointW == word.length()) {
                return true;
            }
            pointT++;
        }
        return false;
    }
}