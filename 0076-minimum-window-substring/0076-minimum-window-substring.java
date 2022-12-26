class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }
        
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int count = t.length();
        
        while (end < s.length()) {
            char sChar = s.charAt(end);
            if (map[sChar] > 0) {
                count--;
            }
            map[sChar]--;
            end++;
            
            while (count == 0) {
                if (minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }
                
                char sChar2 = s.charAt(start);
                map[sChar2]++;
                if (map[sChar2] > 0) {
                    count++;
                }
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}