class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(m, n, maxMove, startRow, startColumn, memo);
    }
    
    public int dfs(int m, int n, int maxMove, int currRow, int currColumn, Map<String, Integer> memo) {
        if (maxMove < 0) {
            return 0;
        }
        if (currRow < 0 || currRow >= m || currColumn < 0 || currColumn >= n) {
            return 1;
        }
        
        String key = Integer.toString(currRow) + "," + Integer.toString(currColumn) + "," + Integer.toString(maxMove);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int paths = 0;
        int[] rDelta = new int[]{1, -1, 0, 0};
        int[] cDelta = new int[]{0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int rNext = currRow + rDelta[i];
            int cNext = currColumn + cDelta[i];
            
            // if (rNext >= m || rNext < 0) {
            //     continue;
            // }
            // if (cNext >= n || cNext < 0) {
            //     continue;
            // }
            paths = (paths + dfs(m, n, maxMove - 1, rNext, cNext, memo)) % 1000000007;
        }
        
        memo.put(key, paths);
        return paths;
    }
}