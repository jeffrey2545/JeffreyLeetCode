class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Map<Integer, List> map = new HashMap<>();
        for (int num : arr) {
            int dis = Math.abs(x - num);
            if (map.containsKey(dis)) {
                List<Integer> oldlist = map.get(dis);
                oldlist.add(num);
                map.replace(dis, map.get(dis), oldlist);
            } else {
                heap.add(dis);
                List<Integer> newlist = new ArrayList<>();
                newlist.add(num);
                map.put(dis, newlist);
            }
        }
        
        // int[] result = new int[k];
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (count < k) {
            int dis = heap.poll();
            List<Integer> list = map.get(dis);
            list.sort((Integer s1, Integer s2) -> s1 - s2);
            for (int num : list) {
                if (count < k) {
                    result.add(num);
                    count++;
                }
            }
        }
        result.sort((Integer s1, Integer s2) -> s1 - s2);
        return result;
    }
}