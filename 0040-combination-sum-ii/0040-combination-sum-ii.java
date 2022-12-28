class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        // int su = Arrays.stream(candidates).sum();
        // int len = candidates.length;
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, path, set, target, 0);
        
        for (List<Integer> list : set) {
            result.add(list);
        }
        return result;
    }
    
    public void dfs(int[] candidates, List<Integer> path, Set<List<Integer>> set, int target, int index) {
        if (candidates.length == index) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue; /** skip duplicates */
            int candidate = candidates[i];
            if (target - candidate == 0) {
                path.add(candidate);
                set.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                break;
            } else if (target - candidate < 0) {
                break;
            } else {
                path.add(candidate);
                dfs(candidates, path, set, target - candidate, i + 1);
                path.remove(path.size() - 1);
            }
        }
        
        return;
    }
}