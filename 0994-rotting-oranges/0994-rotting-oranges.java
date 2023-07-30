class Solution {
    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Position> queue = new ArrayDeque<>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 2) {
                    queue.add(new Position(x, y));
                }
            }
        }
        
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                Position curr = queue.poll();
                int[] deltaX = {0, 0, 1, -1};
                int[] deltaY = {1, -1, 0, 0};
                for (int u = 0; u < 4; u++) {
                    int newX = curr.x + deltaX[u];
                    int newY = curr.y + deltaY[u];
                    if (newX < 0 || newX >= grid.length) {
                        continue;
                    }
                    if (newY < 0 || newY >= grid[0].length) {
                        continue;
                    }
                    if (grid[newX][newY] == 0 || grid[newX][newY] == 2) {
                        continue;
                    }
                    grid[newX][newY] = 2;
                    queue.add(new Position(newX, newY));
                }
            }
        }
        if (time != 0) {
            time--;
        }
        
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    return -1;
                }
            }
        }
        
        return time;
    }
}