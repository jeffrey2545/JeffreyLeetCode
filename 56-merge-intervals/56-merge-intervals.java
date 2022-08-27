class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        
        // intervals.sort((int[][] in1, int[][] in2) -> in1[][0] - in2[][0]);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] A = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] B = intervals[i];
            if (A[1] >= B[0]) {
                int[] C = {A[0], Math.max(A[1], B[1])};
                A = C;
            } else {
                result.add(A);
                A = B;
            }
        }
        result.add(A);
        return result.toArray(new int[result.size()][]);
    }
}