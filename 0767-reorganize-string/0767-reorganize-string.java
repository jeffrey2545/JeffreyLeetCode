class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
            if (map[c - 'a'] > (s.length() + 1) / 2) {
                return "";
            }
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                heap.add(new int[] {i, map[i]});
            }
        }
        
        StringBuilder ans = new StringBuilder();
        while (heap.size() >= 2) {
            int[] first = heap.poll();
            int[] second = heap.poll();
            
            ans.append((char) (first[0] + 'a'));
            ans.append((char) (second[0] + 'a'));
            
            first[1]--;
            second[1]--;
            
            if (first[1] > 0) {
                heap.add(first);
            }
            if (second[1] > 0) {
                heap.add(second);
            }
        }
        
        if (!heap.isEmpty()) {
            ans.append((char) (heap.poll()[0] + 'a'));
        }
        
        return ans.toString();
    }
}
