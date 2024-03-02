class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int oldStart = intervals[0][0];
        int oldEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int newStart = interval[0];
            int newEnd = interval[1];
            if (oldEnd > newStart) {
                return false;
            }
            oldStart = newStart;
            oldEnd = newEnd;
        }
        return true;
    }
}