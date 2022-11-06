class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }

        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        return dfs(s, 0, maxLength, wordDict, new HashMap<Integer, Boolean>());
    }
    
    public boolean dfs(String s, int start, int maxLength, List<String> wordDict, Map<Integer, Boolean> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        if (start == s.length()) {
            return true;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (end - start > maxLength) {
                break;
            }

            String word = s.substring(start, end);
            
            if (!inList(word, wordDict)) {
                continue;
            }

            if (dfs(s, end, maxLength, wordDict, memo)) {
                return true;
            }
        }

        memo.put(start, false);

        return false;
    }
    
    public boolean inList(String target, List<String> wordDict) {
        for (String word : wordDict) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }
}