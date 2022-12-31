class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // put dict in set
        Set<String> dict = new HashSet<>();
        for (String word : words) {
            dict.add(word);
        }
        
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (dfs(word, dict, 0)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    public boolean dfs(String s, Set<String> dict, int left) {
        if (left == s.length()) {
            return true;
        }
        // boolean result = false;
        for (int index = left; index <= s.length(); index++) {
            String word = s.substring(left, index);
            if (!dict.contains(word)) {
                continue;
            }
            if (word.equals(s)) {
                continue;
            }
            // System.out.println(word);
            // result = dfs(s, dict, index);
            if (dfs(s, dict, index)) {
                return true;
            }
        }
        
        return false;
    }
}