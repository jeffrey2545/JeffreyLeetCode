class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int area = bfs(grid, row, col);
                    System.out.println(area);
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }
    
    public int bfs(int[][] grid, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        grid[row][col] = 0;
        int area = 0;
        int[] deltaX = new int[]{1, -1, 0, 0};
        int[] deltaY = new int[]{0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            area++;
            for (int dir = 0; dir < 4; dir++) {
                int newRow = curr[0] + deltaX[dir];
                int newCol = curr[1] + deltaY[dir];
                if (newRow >= grid.length || newRow < 0 || newCol >= grid[0].length || newCol < 0) {
                    continue;
                }
                if (grid[newRow][newCol] == 0) {
                    continue;
                }
                queue.add(new int[]{newRow, newCol});
                grid[newRow][newCol] = 0;
            }
        }
        return area;
    }
}