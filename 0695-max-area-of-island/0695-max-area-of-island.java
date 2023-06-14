public class Position {
    int x;
    int y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    ans = Math.max(ans, bfs(grid, visited, new Position(row, col)));
                }
            }
        }
        return ans;
    }
    
    public int bfs(int[][] grid, boolean[][] visited, Position start) {
        int[] xDelta = {1, -1, 0, 0};
        int[] yDelta = {0, 0, 1, -1};
        
        Queue<Position> queue = new ArrayDeque<>();
        int count = 0;
        queue.add(start);
        visited[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            Position curr = queue.poll();
            count++;
            for (int dir = 0; dir < 4; dir++) {
                int newX = curr.x + xDelta[dir];
                int newY = curr.y + yDelta[dir];
                Position newPos = new Position(newX, newY);
                if (reachable(grid, visited, newPos)) {
                    queue.add(newPos);
                    visited[newX][newY] = true;
                }
            }
        }
        return count;
    }
    
    public boolean reachable(int[][] grid, boolean[][] visited, Position pos) {
        if (pos.x >= grid.length || pos.x < 0) {
            return false;
        }
        if (pos.y >= grid[0].length || pos.y < 0) {
            return false;
        }
        if (visited[pos.x][pos.y]) {
            return false;
        }
        if (grid[pos.x][pos.y] == 0) {
            return false;
        }
        return true;
    }
}