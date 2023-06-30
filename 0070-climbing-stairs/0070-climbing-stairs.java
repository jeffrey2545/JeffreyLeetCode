class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dfs(n, memo);
    }
    
    public int dfs(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int one = dfs(n - 1, memo);
        int two = dfs(n - 2, memo);
        
        memo.put(n, one + two);
        return one + two;
    }
}