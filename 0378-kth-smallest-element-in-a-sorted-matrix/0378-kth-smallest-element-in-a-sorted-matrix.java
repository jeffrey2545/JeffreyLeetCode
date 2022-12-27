class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int row = k/n;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                heap.add(matrix[i][j]);
            }
        }
        
        int result = 0;
        while (k > 0) {
            result = heap.poll();
            k--;
        }
        return result;
    }
}