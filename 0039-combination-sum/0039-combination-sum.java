class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    private void dfs(int[] candidates, int index, int sum, int target, List<Integer> set, List<List<Integer>> result) {
    if (sum == target) {
        result.add(new ArrayList<Integer>(set));
        return;
    }
    if (sum > target) {
        return;
    }
    for (int tmpIndex = index; tmpIndex < candidates.length; tmpIndex++) {      
        set.add(candidates[tmpIndex]);
        dfs(candidates, tmpIndex, sum + candidates[tmpIndex], target, set, result);
        set.remove(set.size() - 1);
    }
    return;
    }
}