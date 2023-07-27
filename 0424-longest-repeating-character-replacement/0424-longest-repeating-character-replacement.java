class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int right = 0; right < s.length(); right++) {
            char word = s.charAt(right);
            map.put(word, map.getOrDefault(word, 0) + 1);
            while ((right - left + 1) - Collections.max(map.values()) > k) {
                char replaceWord = s.charAt(left);
                map.put(replaceWord, map.get(replaceWord) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}