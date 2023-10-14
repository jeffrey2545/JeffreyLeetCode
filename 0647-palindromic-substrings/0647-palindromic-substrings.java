class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < length - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        
        for (int size = 3; size <= length; size++) {
            for (int l = 0, r = l + size - 1; r < length; l++, r++) {
                dp[l][r] = dp[l + 1][r - 1] && (s.charAt(l) == s.charAt(r));
            }
        }
        
        int ans = 0;
        for (boolean[] row : dp) {
            for (boolean col : row) {
                if (col) {
                    ans++;
                }
            }
        }
        return ans;
    }
}