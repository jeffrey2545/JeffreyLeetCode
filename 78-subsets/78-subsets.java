class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        
        dfs(nums, 0, subset, result);

        return result;
    }
    
    public void dfs(int[] nums, int point, List<Integer> subset, List<List<Integer>> result) {
        if (point == nums.length) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }

        int num = nums[point];
        subset.add(num);
        dfs(nums, point + 1, subset, result);

        subset.remove(subset.size() - 1);
        dfs(nums, point + 1, subset, result);

        return;
    }
}