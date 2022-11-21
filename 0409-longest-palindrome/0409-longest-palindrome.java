class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (char word : s.toCharArray()) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.replace(word, count, count + 1);
            } else {
                map.put(word, 1);
                list.add(word);
            }
        }
        
        int result = 0;
        boolean odd = false;
        for (char word : list) {
            int count = map.get(word);
            // System.out.println(word);
            // System.out.println(count);
            if (count % 2 == 0) {
                result = result + count;
            } else {
                odd = true;
                result = result + count - 1;
            }
        }
        
        if (odd) {
            return result + 1;
        } else {
            return result;
        }
    }
}