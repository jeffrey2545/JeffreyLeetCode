class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int[] ans = new int[n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = count(i, dp);
        }
        return ans;
    }
    
    public int count(int n, int[] dp) {
        int count = 0;
        while (n != 0) {
            if (dp[n] != 0) {
                count = count + dp[n];
            } else {
                count = count + (n & 1);
            }
            n = n >>> 1;
        }
        dp[n] = count;
        return count;
    }
}