class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        
        Set<Long> set = new HashSet<>();
        set.add(1L);
        
        int[] factors = new int[] {2, 3, 5};
        
        long currUgly = 1L;
        
        for (int i = 0; i < n; i++) {
            currUgly = heap.poll();
            if (i == n - 1) {
                continue;
            }
            
            for (int factor : factors) {
                long newUgly = currUgly * factor;
                if (!set.contains(newUgly)) {
                    heap.add(newUgly);
                    set.add(newUgly);
                }
            }
        }
        return (int)currUgly;
    }
}