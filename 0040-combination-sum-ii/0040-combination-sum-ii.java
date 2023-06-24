class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<>(), target, candidates, 0);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> combination, int target, int[] candidates, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        
        HashSet<Integer> visited = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            if (visited.contains(candidates[i])) {
                continue;
            }
            visited.add(candidates[i]);
            combination.add(candidates[i]);
            dfs(ans, combination, target - candidates[i], candidates, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}