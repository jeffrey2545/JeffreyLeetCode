
class Solution {
    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    boolean[][] visited;
    
    public void solve(char[][] board) {
        visited = new boolean[board.length][board[0].length];
        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }
        for (int row = 1; row < board.length; row++) {
            for (int col = 1; col < board[0].length; col++) {
                if (visited[row][col] || board[row][col] == 'X') {
                    visited[row][col] = true;
                    continue;
                }
                List<Position> flips = bfs(board, new Position(row, col));
                for (Position pos : flips) {
                    board[pos.x][pos.y] = 'X';
                }
            }
        }
    }
    
    public List<Position> bfs(char[][] board, Position start) {
        List<Position> flips = new ArrayList<>();
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(start);
        flips.add(start);
        visited[start.x][start.y] = true;
        boolean negative = false;
        while (!queue.isEmpty()) {
            Position curr = queue.poll();
            if (curr.x == 0 || curr.x == board.length - 1) {
                negative = true;
            }
            if (curr.y == 0 || curr.y == board[0].length - 1) {
                negative = true;
            }
            int[] deltaX = {0, 0, 1, -1};
            int[] deltaY = {1, -1, 0, 0};
            for (int i = 0; i < 4; i++) {
                int newX = curr.x + deltaX[i];
                int newY = curr.y + deltaY[i];
                if (newX < 0 || newX >= board.length) {
                    continue;
                }
                if (newY < 0 || newY >= board[0].length) {
                    continue;
                }
                if (board[newX][newY] == 'X') {
                    continue;
                }
                if (visited[newX][newY]) {
                    continue;
                }
                Position newPos = new Position(newX, newY);
                queue.add(newPos);
                flips.add(newPos);
                visited[newPos.x][newPos.y] = true;
            }
        }
        if (negative) {
            return new ArrayList<>();
        }
        return flips;
    }
}