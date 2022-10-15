class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        dfs(n, 0, 0, "", result);
        return result;
    }
    private void dfs(int n, int left, int right, String set, List<String> result) {
        if (set.length() == n * 2) {
            result.add(set);
            return;
        }
        if (left < n) {
            dfs(n, left + 1, right, set + "(", result);

        }
        if (right < left) {
            dfs(n, left, right + 1, set + ")", result);
        }
    }
}