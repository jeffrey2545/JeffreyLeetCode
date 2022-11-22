class Solution {
    public class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[0].length; k++) {
                //System.out.println(visited[i][k]);
                //System.out.println(grid[i][k]);
                if ((visited[i][k] == false) && (grid [i][k] == '1')) {
                    //System.out.println("in");
                    bfs(grid, visited, i, k);
                    result++;
                }
            }
        }
        return result;
    }
    
    public void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<Pair> queue = new ArrayDeque<>();
        visited[x][y] = true;
        Pair init = new Pair(x, y);
        queue.offer(init);
        // int count = 0;
        while (!queue.isEmpty()) {
            // count++;
            Pair land = queue.poll();
            if ((land.x - 1) >= 0 && !visited[land.x - 1][land.y] && grid[land.x - 1][land.y] == '1') {
                visited[land.x - 1][land.y] = true;
                Pair newLand = new Pair(land.x - 1, land.y);
                queue.offer(newLand);
            }
            if ((land.y + 1) < grid[0].length && !visited[land.x][land.y + 1] && grid[land.x][land.y + 1] == '1') {
                visited[land.x][land.y + 1] = true;
                Pair newLand = new Pair(land.x, land.y + 1);
                queue.offer(newLand);
            }
            if ((land.x + 1) < grid.length && !visited[land.x + 1][land.y] && grid[land.x + 1][land.y] == '1') {
                visited[land.x + 1][land.y] = true;
                Pair newLand = new Pair(land.x + 1, land.y);
                queue.offer(newLand);
            }
            if ((land.y - 1) >= 0 && !visited[land.x][land.y - 1] && grid[land.x][land.y - 1] == '1') {
                visited[land.x][land.y - 1] = true;
                Pair newLand = new Pair(land.x, land.y - 1);
                queue.offer(newLand);
            }
        }
        // System.out.println(count);
        return;
    }
}