class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0;
        int down = matrix.length - 1;
        
        while (up + 1 < down) {
            int mid = up + (down - up) / 2;
            
            if (target < matrix[mid][0]) {
                down = mid;
            } else if (target > matrix[mid][0]) {
                up = mid;
            } else if (target == matrix[mid][0]) {
                return true;
            }
        }
        
        if (target >= matrix[down][0]) {
            return searchRow(matrix[down], target);
        } else {
            return searchRow(matrix[up], target);
        }
    }
    
    public boolean searchRow(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (target < row[mid]) {
                right = mid - 1;
            } else if (target > row[mid]) {
                left = mid + 1;
            } else if (target == row[mid]) {
                return true;
            }
        }
        
        return false;
    }
}