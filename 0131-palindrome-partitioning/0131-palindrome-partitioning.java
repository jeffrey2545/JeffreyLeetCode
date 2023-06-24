class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), s, 0);
        return ans;
    }
    
    public void dfs(List<List<String>> ans, List<String> possible, String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(possible));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            String string = s.substring(start, i + 1);
            if (!isPalindrome(string)) {
                continue;
            }
            possible.add(string);
            dfs(ans, possible, s, i + 1);
            possible.remove(possible.size() - 1);
        }
    }
    
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}