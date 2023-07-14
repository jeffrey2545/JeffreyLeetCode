class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n, ans, "", 0, 0);
        return ans;
    }
    private void dfs(int n, List<String> ans, String string, int left, int right) {
      if (string.length() == n * 2) {
        ans.add(string);
        return;
      }


      if (left < n) {
        dfs(n, ans, string + "(", left + 1, right);// left
      }
      if (left > right) {
        dfs(n, ans, string + ")", left, right + 1);// right
      }
    }
}