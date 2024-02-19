class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for (int key : map.keySet()) {
            heap.add(key);
        }
        
        while (k >= 0 && !heap.isEmpty()) {
            int key = heap.poll();
            int count = map.get(key);
            if (k >= count) {
                k = k - count;
                map.remove(key);
            } else {
                count = count - k;
                map.put(key, count);
                k = -1;
            }
        }
        
        return map.size();
    }
}
// 1 -> 2
// 2 -> 1
// 3 -> 3
// 4 -> 1