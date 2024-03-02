class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        for (int[] interval : intervals) {
            rightHeap.add(interval);
        }
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        leftHeap.add(rightHeap.poll()[1]);
        int ans = 1;
        
        while (!rightHeap.isEmpty()) {
            int[] interval = rightHeap.poll();
            if (leftHeap.peek() <= interval[0]) {
                int out = leftHeap.poll();
            }
            leftHeap.add(interval[1]);
            ans = Math.max(ans, leftHeap.size());
        }
        
        return ans;
    }
}