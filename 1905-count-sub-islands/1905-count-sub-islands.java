class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        for (int x = 0; x < grid2.length; x++) {
            for (int y = 0; y < grid2[x].length; y++) {
                if (grid2[x][y] == 1) {
                    if (bfs(grid1, grid2, x, y)) {
                        ans++;
                    }
                }
            }
        }
        
        return ans;
    }
    
    public boolean bfs(int[][] grid1, int[][] grid2, int x, int y) {
        boolean subIsland = true;
        int[] deltaX = new int[] {1, -1, 0, 0};
        int[] deltaY = new int[] {0, 0, 1, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            // check grid1
            if (grid1[curr[0]][curr[1]] == 0) {
                subIsland = false;
            }
            for (int i = 0; i < 4; i++) {
                int[] next = new int[] {curr[0] + deltaX[i], curr[1] + deltaY[i]};
                if (next[0] < 0 || next[0] >= grid2.length) {
                    continue;
                }
                if (next[1] < 0 || next[1] >= grid2[0].length) {
                    continue;
                }
                if (grid2[next[0]][next[1]] == 0) {
                    continue;
                }
                queue.add(next);
                grid2[next[0]][next[1]] = 0;
                // check grid1
            }
        }
        
        return subIsland;
    }
}