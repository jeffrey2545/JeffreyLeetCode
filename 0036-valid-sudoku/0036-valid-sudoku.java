class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != '.') {
                    if (!noConflict(board, x, y)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean noConflict(char[][] board, int x, int y) {
        // 九宮格
        int r;
        if (x <= 2) {
            r = 0;
        } else if (x > 2 && x <= 5) {
            r = 3;
        } else {
            r = 6;
        }
        int c;
        if (y <= 2) {
            c = 0;
        } else if (y > 2 && y <= 5) {
            c = 3;
        } else {
            c = 6;
        }
        for (int row = r; row < r + 3; row++) {
            for (int col = c; col < c + 3; col++) {
                if (row == x && col == y) {
                    continue;
                }
                if (board[row][col] == board[x][y]) {
                    return false;
                }
            }
        }
        // 直的
        for (int row = 0; row < 9; row++) {
            if (row == x) {
                continue;
            }
            if (board[row][y] == board[x][y]) {
                return false;
            }
        }
        // 橫的
        for (int col = 0; col < 9; col++) {
            if (col == y) {
                continue;
            }
            if (board[x][col] == board[x][y]) {
                return false;
            }
        }
        
        return true;
    }
}