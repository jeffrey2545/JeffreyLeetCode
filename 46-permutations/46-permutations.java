class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>(), result);

        return result;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> subSet, List<List<Integer>> result) {
        if (subSet.size() == nums.length) {
            result.add(new ArrayList<Integer>(subSet));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            subSet.add(nums[i]);
            dfs(nums, visited, subSet, result);
            subSet.remove(subSet.size() - 1);
            visited[i] = false;
        }
    }
}