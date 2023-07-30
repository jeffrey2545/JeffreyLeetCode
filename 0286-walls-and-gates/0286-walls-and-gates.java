class Solution {
    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        Queue<Position> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[0].length; y++) {
                visited[x][y] = false;
                if (rooms[x][y] == 0) {
                    queue.add(new Position(x, y));
                    visited[x][y] = true;
                }
            }
        }
        int distance = 0;
        
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position curr = queue.poll();
                int[] deltaX = {0, 0, 1, -1};
                int[] deltaY = {1, -1, 0, 0};
                for (int dir = 0; dir < 4; dir++) {
                    int newX = curr.x + deltaX[dir];
                    int newY = curr.y + deltaY[dir];
                    if (newX < 0 || newX >= rooms.length) {
                        continue;
                    }
                    if (newY < 0 || newY >= rooms[0].length) {
                        continue;
                    }
                    if (rooms[newX][newY] == -1) {
                        continue;
                    }
                    if (visited[newX][newY]) {
                        continue;
                    }
                    rooms[newX][newY] = distance;
                    queue.add(new Position(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }
}