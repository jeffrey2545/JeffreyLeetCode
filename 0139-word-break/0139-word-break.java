class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        int[] memo = new int[s.length()];
        
        return dfs(s, 0, set, memo);
    }
    
    public boolean dfs(String s, int start, Set<String> set, int[] memo) {
        if (start == s.length()) {
            return true;
        }
        
        if (memo[start] == 1) {
            return true;
        } else if (memo[start] == -1) {
            return false;
        }
        
        boolean success = false;
        for (int end = start + 1; end <= s.length(); end++) {
            String newS = s.substring(start, end);
            if (set.contains(newS)) {
                if (dfs(s, end, set, memo)) {
                    success = true;
                }
            } else {
                continue;
            }
        }
        
        if (success) {
            memo[start] = 1;
        } else {
            memo[start] = -1;
        }
        return success;
    }
}