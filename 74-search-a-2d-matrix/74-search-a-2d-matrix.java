class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) {
            return false;
        }
        
        int startPoint = 0;
        int endPoint = (matrix[0].length * matrix.length) - 1;
        while (startPoint + 1 < endPoint) {
            int midPoint = (startPoint + endPoint) / 2;
            int mid = oneToTwo(matrix, midPoint);
            if (mid == target) {
                return true;
            }
            if (mid > target) {
                endPoint = midPoint;
            }
            if (mid < target) {
                startPoint = midPoint;
            }
        }
        
        int start = oneToTwo(matrix, startPoint);
        int end = oneToTwo(matrix, endPoint);
        if (target == start ||target == end) {
            return true;
        }
        return false;
    }
    
    public int oneToTwo(int[][] matrix, int pointer) {
        int x = pointer / matrix[0].length;
        int y = (pointer % matrix[0].length);
        return matrix[x][y];
    }
}