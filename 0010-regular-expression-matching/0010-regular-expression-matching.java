class Solution {
    int[][] memo;
    
    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, 2);
        }
        return dfs(s, p, 0, 0);
    }
    
    public boolean dfs(String s, String p, int sI, int pI) {
        // base case
        if (sI == s.length() && pI == p.length()) {
            return true;
        }
        if (pI == p.length()) {
            return false;
        }
        
        // memo
        if (memo[sI][pI] == 0) {
            return false;
        } else if (memo[sI][pI] == 1) {
            return true;
        }
        
        // next
        boolean currMatch = sI < s.length() && ((s.charAt(sI) == p.charAt(pI)) || (p.charAt(pI) == '.'));
        boolean next;
        if (pI + 1 < p.length() && p.charAt(pI + 1) == '*') {
            next = (dfs(s, p, sI, pI + 2)) || (currMatch && dfs(s, p, sI + 1, pI));
        } else {
            next = currMatch && dfs(s, p, sI + 1, pI + 1);
        }
        
        if (next) {
            memo[sI][pI] = 1;
        } else {
            memo[sI][pI] = 0;
        }
        return next;
    }
}