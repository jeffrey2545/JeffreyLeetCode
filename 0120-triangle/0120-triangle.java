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
        return dp4(triangle);
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
    
    private int dp1(List<List<Integer>> triangle) {
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
    
    private int dp2(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height][triangle.get(height - 1).size()];
        
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < height; i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            int bottom = triangle.get(i).size() - 1;
            dp[i][bottom] = triangle.get(i).get(bottom) + dp[i - 1][bottom - 1];
        }
        
        for (int i = 2; i < height; i++) {
            for (int k = 1; k < triangle.get(i).size() - 1; k++) {
                dp[i][k] = Math.min(dp[i - 1][k], dp[i - 1][k - 1]) + triangle.get(i).get(k);
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int num : dp[height - 1]) {
            // System.out.println(num);
            if (num < result) {
                result = num;
            }
        }
        return result;
    }
    
    public int dp3(List<List<Integer>> triangle) {
        int triangleHeight = triangle.size();
        int[][] memo = new int[triangleHeight][triangle.get(triangleHeight - 1).size()];
        
        for (int left = 0; left < triangle.get(triangleHeight - 1).size(); left++) {
            memo[triangleHeight - 1][left] = triangle.get(triangleHeight - 1).get(left);
        }
        
        for (int height = triangleHeight - 2; height >= 0; height--) {
            for (int left = 0; left < triangle.get(height).size(); left++) {
                memo[height][left] = Math.min(memo[height + 1][left], memo[height + 1][left + 1]) + triangle.get(height).get(left);
            }
        }
        
        return memo[0][0];
    }
    
    public int dp4(List<List<Integer>> triangle) {
        int triangleHeight = triangle.size();
        int[][] memo = new int[triangleHeight][triangle.get(triangleHeight - 1).size()];
        
        memo[0][0] = triangle.get(0).get(0);
        for (int height = 1; height < triangleHeight; height++) {
            memo[height][0] = memo[height - 1][0] + triangle.get(height).get(0);
            int right = triangle.get(height).size() - 1;
            memo[height][right] = memo[height - 1][right - 1] + triangle.get(height).get(right);
        }
        
        for (int height = 2; height < triangleHeight; height++) {
            for (int left = 1; left < triangle.get(height).size() - 1; left++) {
                memo[height][left] = Math.min(memo[height - 1][left - 1], memo[height - 1][left]) + triangle.get(height).get(left);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int path : memo[triangleHeight - 1]) {
            ans = Math.min(ans, path);
        }
        return ans;
    }
}