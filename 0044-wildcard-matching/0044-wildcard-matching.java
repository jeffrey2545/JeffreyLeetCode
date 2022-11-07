class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return dfs(s, p, 0, 0, memo, visited);
    }
    
    public boolean dfs(String source, String pattern, int sIndex, int pIndex, boolean[][] memo, boolean[][] visited) {
        if (pattern.length() == pIndex) {
            return source.length() == sIndex;
        }

        if (source.length() == sIndex) {
            return star(pattern, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        char sChar = source.charAt(sIndex);
        char pChar = pattern.charAt(pIndex);
        boolean result;

        if (pChar != '*') {
            result = match(sChar, pChar) && dfs(source, pattern, sIndex + 1, pIndex + 1, memo, visited);
        } else {
            result = dfs(source, pattern, sIndex + 1, pIndex, memo, visited) || dfs(source, pattern, sIndex, pIndex + 1, memo, visited);
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = result;

        return result;
    }

    public boolean star(String pattern, int pIndex) {
        for (int i = pIndex; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean match(char sChar, char pChar) {
        return (sChar == pChar || pChar == '?');
    }
}