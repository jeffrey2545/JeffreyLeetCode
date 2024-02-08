class Solution {
    public String frequencySort(String s) {
        // throw to map, key = char, val = count
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // System.out.print(map);
        // use heap to pop the largest count and val
        PriorityQueue<Character> heap = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );
        for (Character ch : map.keySet()) {
            heap.add(ch);
        }
        // System.out.print(heap);
        // print out
        StringBuilder ans = new StringBuilder();
        while (!heap.isEmpty()) {
            char ch = heap.poll();
            int count = map.get(ch);
            for (int i = 0; i < count; i++) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}