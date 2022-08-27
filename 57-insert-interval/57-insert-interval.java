class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] re = {newInterval};
            return re;
        }
        int[][] newIntervals = new int[intervals.length + 1][2];
        int x = 0;
        boolean insert = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= newInterval[0]) {
                if (insert) {
                    newIntervals[x] = intervals[i];
                    x++;
                } else {
                    newIntervals[x] = newInterval;
                    x++;
                    newIntervals[x] = intervals[i];
                    x++;
                    insert = true;
                }
            } else {
                newIntervals[x] = intervals[i];
                x++;
            }
        }
        if (!insert) {
            newIntervals[intervals.length] = newInterval;
        }
        
        List<int[]> result = new ArrayList<>();
        int[] A = newIntervals[0];
        for (int i = 1; i < newIntervals.length; i++) {
            int[] B = newIntervals[i];
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