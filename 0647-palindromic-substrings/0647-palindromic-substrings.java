class Solution {
    public int countSubstrings(String s) {
        // create dp
        boolean[][] dp = new boolean[s.length()][s.length()]; // left and right
        // initialize dp
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp[i - 1][i] = true;
            }
        }
        // build dp
        for (int size = 3; size <= s.length(); size++) {
            for (int left = 0, right = left + size - 1; right < s.length(); left++, right++) {
                dp[left][right] = dp[left + 1][right - 1] && (s.charAt(left) == s.charAt(right));
            }
        }
        // count
        int count = 0;
        for (boolean[] row : dp) {
            for (boolean col : row) {
                if (col) {
                    count++;
                }
            }
        }
        return count;
    }
}