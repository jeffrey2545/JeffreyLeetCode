class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // sorted by start time
        Arrays.sort(intervals, (int[] intervalA, int[] intervalB) -> intervalA[0] - intervalB[0]);
        // pick interval from intervals
        // put it in list
        List<int[]> rooms =  new ArrayList<>();
        rooms.add(intervals[0]);
        int ans = 1;
        // every time one new interval into list, check if there is place
        // every time the list size changed, update the max rooms
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            boolean change = false;
            for (int r = 0; r < rooms.size(); r++) {
                int[] room = rooms.get(r);
                if (interval[0] >= room[1]) {
                    rooms.set(r, interval);
                    change = true;
                    break;
                }
            }
            
            if (!change) {
                rooms.add(interval);
            }
            ans = Math.max(ans, rooms.size());
        }
        
        return ans;
    }
}