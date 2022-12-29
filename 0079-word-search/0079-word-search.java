public class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (boolean[] row : visited)
            Arrays.fill(row, false);
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == word.charAt(0)) {
                    visited[y][x] = true;
                    if (check(board, word.toCharArray(), 1, new Pair(x, y), visited)) {
                        return true;
                    }
                    visited[y][x] = false;
                } else {
                    continue;
                }
            }
        }
        return false;
    }
    
    public boolean check(char[][] board, char[] word, int target, Pair curr, boolean[][] visited) {
        // System.out.println("inside");
        if (target == word.length) {
            // System.out.println("end");
            return true;
        }
        
        if (curr.x + 1 < board[0].length && !visited[curr.y][curr.x + 1] && board[curr.y][curr.x + 1] == word[target]) {
            // System.out.println("右");
            visited[curr.y][curr.x + 1] = true;
            if (check(board, word, target + 1, new Pair(curr.x + 1, curr.y), visited)) {
                return true;
            }
            visited[curr.y][curr.x + 1] = false;
        }
        if (curr.x - 1 >= 0 && !visited[curr.y][curr.x - 1] && board[curr.y][curr.x - 1] == word[target]) {
            // System.out.println("左");
            visited[curr.y][curr.x - 1] = true;
            if (check(board, word, target + 1, new Pair(curr.x - 1, curr.y), visited)) {
                return true;
            }
            visited[curr.y][curr.x - 1] = false;
        }
        if (curr.y + 1 < board.length && !visited[curr.y + 1][curr.x] && board[curr.y + 1][curr.x] == word[target]) {
            // System.out.println("下");
            visited[curr.y + 1][curr.x] = true;
            if (check(board, word, target + 1, new Pair(curr.x, curr.y + 1), visited)) {
                return true;
            }
            visited[curr.y + 1][curr.x] = false;
        }
        if (curr.y - 1 >= 0 && !visited[curr.y - 1][curr.x] && board[curr.y - 1][curr.x] == word[target]) {
            // System.out.println("上");
            visited[curr.y - 1][curr.x] = true;
            if (check(board, word, target + 1, new Pair(curr.x, curr.y - 1), visited)) {
                return true;
            }
            visited[curr.y - 1][curr.x] = false;
        }
        return false;
    }
}