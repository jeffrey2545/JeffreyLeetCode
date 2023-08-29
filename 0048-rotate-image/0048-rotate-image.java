class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int row = 0; row < (size + 1) / 2; row++) {
            for (int col = 0; col < size / 2; col++) {
                int a = matrix[row][col];
                int b = matrix[col][size - row - 1];
                int c = matrix[size - row - 1][size - col - 1];
                int d = matrix[size - col - 1][row];
                
                matrix[row][col] = d;
                matrix[col][size - row - 1] = a;
                matrix[size - row - 1][size - col - 1] = b;
                matrix[size - col - 1][row] = c;
            }
        }
    }
}