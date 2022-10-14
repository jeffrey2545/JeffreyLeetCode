class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> set, List<List<Integer>> result) {
        if (set.size() == nums.length) {
            result.add(new ArrayList<Integer>(set));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            visited[i] = true;
            set.add(nums[i]);
            dfs(nums, visited, set, result);
            set.remove(set.size() - 1);
            visited[i] = false;
        }
    }
}