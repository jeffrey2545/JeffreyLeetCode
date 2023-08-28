class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (newInterval[1] < interval[0]) {
                list.add(newInterval);
                while (i < intervals.length) {
                    list.add(intervals[i]);
                    i++;
                }
                return list.toArray(new int[list.size()][2]);
            }
            if (interval[1] < newInterval[0]) {
                list.add(interval);
                continue;
            }
            int start = Math.min(newInterval[0], interval[0]);
            int end = Math.max(newInterval[1], interval[1]);
            newInterval[0] = start;
            newInterval[1] = end;
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][2]);
    }
}