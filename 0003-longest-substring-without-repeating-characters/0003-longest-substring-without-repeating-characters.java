class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {// move left
            char word = s.charAt(right);
            while (!set.contains(word)) {// move right
                set.add(word);
                ans = Math.max(ans, set.size());
                right++;
                if (right < s.length()) {
                    word = s.charAt(right);
                }
            }
            set.remove(s.charAt(left));
            left++;
        }
        return ans;
    }
}