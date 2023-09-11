class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> mainHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            mainHeap.add(interval);
        }
        
        int[] first = mainHeap.poll();
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
        smallHeap.add(first[1]);
        int ans = smallHeap.size();
        while (!mainHeap.isEmpty()) {
            int[] interval = mainHeap.poll();
            if (interval[0] < smallHeap.peek()) {
                smallHeap.add(interval[1]);
            } else {
                smallHeap.poll();
                smallHeap.add(interval[1]);
            }
            ans = Math.max(ans, smallHeap.size());
        }
        return ans;
    }
}