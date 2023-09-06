class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Map<Pair<Integer, Integer>, Boolean> memo = new HashMap<>();
        return dfs(s1, s2, s3, 0, 0, memo);
    }
    
    public boolean dfs(String s1, String s2, String s3, int i1, int i2, Map<Pair<Integer, Integer>, Boolean> memo) {
        if (i1 == s1.length() && i2 == s2.length()) {
            if (i1 + i2 == s3.length()) {
                return true;
            } else {
                return false;
            }
        }
        
        if (memo.containsKey(new Pair<>(i1, i2))) {
            return memo.get(new Pair<>(i1, i2));
        }
        
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1 + i2) && dfs(s1, s2, s3, i1 + 1, i2, memo)) {
            return true;
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1 + i2) && dfs(s1, s2, s3, i1, i2 + 1, memo)) {
            return true;
        }
        memo.put(new Pair<>(i1, i2), false);
        return false;
    }
}