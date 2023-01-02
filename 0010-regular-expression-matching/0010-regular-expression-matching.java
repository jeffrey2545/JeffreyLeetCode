class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] visited = new boolean[s.length() + 1][p.length() + 1];
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        
        return dfs(s, p, 0, 0, visited, memo);
    }
    
    public boolean dfs(String source, String pattern, int sIndex, int pIndex, boolean[][] visited, boolean[][] memo) {
        if (pIndex == pattern.length()) {
            return sIndex == source.length();
        }
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        
        // char sCh = source.charAt(sIndex);
        char pCh = pattern.charAt(pIndex);
        boolean result = false;
        if (pIndex + 1 < pattern.length() && pattern.charAt(pIndex + 1) == '*') {
            if (dfs(source, pattern, sIndex, pIndex + 2, visited, memo)) {
                result = true;
            }
            if (sIndex < source.length() && (pCh == '.' || pCh == source.charAt(sIndex))) {
                if (dfs(source, pattern, sIndex + 1, pIndex, visited, memo)) {
                    result = true;
                }
            }
        } else if (sIndex < source.length()) {
            result = match(source.charAt(sIndex), pCh) && dfs(source, pattern, sIndex + 1, pIndex + 1, visited, memo);
        }
        
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = result;
        return result;
    }
    
    public boolean match(char sCh, char pCh) {
        return (sCh == pCh) || pCh == '.';
    }
}