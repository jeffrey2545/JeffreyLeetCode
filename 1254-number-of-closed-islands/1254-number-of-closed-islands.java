public class Position {
  int x;
  int y;
  Position(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Solution {
    public int closedIsland(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
          for (int col = 0; col < grid[0].length; col++) {
            if (grid[row][col] == 0 && !visited[row][col]) {
              ans = ans + island(grid, visited, new Position(row, col));
            }
          }
        }
        return ans;
    }

    public int island(int[][] grid, boolean[][] visited, Position init) {
      int x = 1;

      Queue<Position> queue = new ArrayDeque<>();
      queue.add(init);
      if (getLimit(grid, init)) {
        x = 0;
      }
      visited[init.x][init.y] = true;

      int[] xDelta = {1, -1, 0, 0};
      int[] yDelta = {0, 0, 1, -1};
      while (!queue.isEmpty()) {
        Position curr = queue.poll();
        for (int dir = 0; dir < 4; dir++) {
          int newX = curr.x + xDelta[dir];
          int newY = curr.y + yDelta[dir];

          if (newX >= 0 && newX < grid.length) {
            if (newY >= 0 && newY < grid[0].length) {
              if (!visited[newX][newY] && grid[newX][newY] == 0) {
                queue.add(new Position(newX, newY));
                if (getLimit(grid, new Position(newX, newY))) {
                  x = 0;
                }
                visited[newX][newY] = true;
              }
            }
          }
        }
      }

      return x;
    }

    public boolean getLimit(int[][] grid, Position curr) {
      if (curr.x == 0 || curr.x == grid.length - 1) {
        return true;
        }
      if (curr.y == 0 || curr.y == grid[0].length - 1) {
        return true;
      }
      return false;
    }
}