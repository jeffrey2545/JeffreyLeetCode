class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, new ArrayList<>(), 0, nums);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> subset, int index, int[] nums) {
        ans.add(new ArrayList<>(subset));
        
        if (subset.size() == nums.length) {
            return;
        }
        
        HashSet<Integer> duplicate = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (duplicate.contains(nums[i])) {
                continue;
            }
            duplicate.add(nums[i]);
            subset.add(nums[i]);
            dfs(ans, subset, i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }
}