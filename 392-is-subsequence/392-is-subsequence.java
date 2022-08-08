class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0 && t.length() != 0) {
            return true;
        } else if (t.length() == 0 && s.length() != 0) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        
        int sPoint = 0, tPoint = 0;
        while (sPoint < s.length()) {
            if (tPoint == t.length() && sPoint < s.length()) {
                return false;
            }
            if (t.charAt(tPoint) == s.charAt(sPoint)) {
                sPoint++;
                tPoint++;
            } else {
                tPoint++;
            }
        }
        return true;
    }
}