class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        
        dfs2(nums, 0, subset, result);

        return result;
    }
    
    private void dfs1(int[] nums, int point, List<Integer> subset, List<List<Integer>> result) {
        if (point == nums.length) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }

        int num = nums[point];
        subset.add(num);
        dfs1(nums, point + 1, subset, result);

        subset.remove(subset.size() - 1);
        dfs1(nums, point + 1, subset, result);

        return;
    }
    
    private void dfs2(int[] nums, int point, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(subset));
        for (int tmpPoint = point; tmpPoint < nums.length; tmpPoint++) {
            subset.add(nums[tmpPoint]);
            dfs2(nums, tmpPoint + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}