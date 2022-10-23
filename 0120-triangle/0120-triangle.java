class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        // return dfs(triangle, 0, 0, new HashMap<Pair, Integer>());
        return dp(triangle);
    }
    
    private int dfs(List<List<Integer>> triangle, int x, int y, Map<Pair, Integer> map) {
        if (triangle.size() == x) {
            return 0;
        }
        
        Pair pair = new Pair(x, y);
        if (map.containsKey(pair)) {
            return map.get(pair);
        }
        
        int left = dfs(triangle, x + 1, y, map);
        int right = dfs(triangle, x + 1, y + 1, map);
        
        int min = Math.min(left, right) + triangle.get(x).get(y);
        map.put(pair, min);
        return min;
    }
    
    private int dp(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height][triangle.get(height - 1).size()];
        
        for (int i = 0; i < triangle.get(height - 1).size(); i++) {
            int init = triangle.get(height - 1).get(i);
            // System.out.println("Initial: " + init);
            dp[height - 1][i] = init;
        }
        
        for (int i = height - 2; i > -1; i--) {
            // System.out.println("first");
            for (int k = 0; k < triangle.get(i).size(); k++) {
                // System.out.println("second");
                int sum = Math.min(dp[i + 1][k], dp[i + 1][k + 1]) + triangle.get(i).get(k);
                // System.out.println("sum: " + sum);
                dp[i][k] = sum;
            }
        }
        
        return dp[0][0];
    }
}