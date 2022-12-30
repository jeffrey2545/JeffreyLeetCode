class Solution {
    int[] memo = new int[32];
    public int fib(int n) {
        Arrays.fill(memo, -1);
        return dfs(n);
    }
    
    public int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        
        int f = fib(n - 1) + fib(n - 2);
        // System.out.println(n);
        // System.out.println(memo.length);
        memo[n] = f;
        return f;
    }
}