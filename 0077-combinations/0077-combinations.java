class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, path, result);
        return result;
    }
    
    public void dfs(int n, int k, List<Integer> path, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int num = n; num > 0; num--) {
            path.add(num);
            dfs(num - 1, k - 1, path, result);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}