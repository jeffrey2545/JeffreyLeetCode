class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }
    
    public int dfs(int[] cost, int index) {
        if (index == cost.length - 1 || index == cost.length - 2) {
            return cost[index];
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        
        int sum = Math.min(dfs(cost, index + 1), dfs(cost, index + 2)) + cost[index];
        memo[index] = sum;
        return sum;
    }
}