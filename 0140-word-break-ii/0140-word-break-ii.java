class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // put dict in set
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        // use dfs with two pointer on s put every word in list
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(s, dict, 0, temp, result);
        return result;
    }
    
    public void dfs(String s, Set<String> dict, int left, List<String> temp, List<String> result) {
        if (left == s.length()) {
            // System.out.println("end");
            String sent = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                sent = sent + " " + temp.get(i);
            }
            result.add(sent);
            return;
        }
        
        for (int index = left; index <= s.length(); index++) {
            String word = s.substring(left, index);
            if (!dict.contains(word)) {
                continue;
            }
            // System.out.println(word);
            temp.add(word);
            dfs(s, dict, index, temp, result);
            temp.remove(temp.size() - 1);
        }
        
        return;
    }
}