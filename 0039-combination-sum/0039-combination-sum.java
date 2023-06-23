class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), candidates, target, 0, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, int[] candidates, int target, int sum, int index) {
      if (sum == target) {
        ans.add(new ArrayList<>(path));
        return;
      }
      if (sum > target) {
        return;
      }

      for (int i = index; i < candidates.length; i++) {
        int candidate = candidates[i];
         
        path.add(candidate);
        sum = sum + candidate;
        dfs(ans, path, candidates, target, sum, i);
        sum = sum - candidate;
        path.remove(path.size() - 1);
      }
    }
}