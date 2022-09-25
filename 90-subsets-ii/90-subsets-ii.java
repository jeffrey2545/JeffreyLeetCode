class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        
        dfs2(nums, 0, subset, result);

        return result;
    }
    
    private void dfs2(int[] nums, int point, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(subset));
        for (int tmpPoint = point; tmpPoint < nums.length; tmpPoint++) {
            if (tmpPoint != 0 && nums[tmpPoint] == nums[tmpPoint - 1] && tmpPoint > point) {
                continue;
            }
            subset.add(nums[tmpPoint]);
            dfs2(nums, tmpPoint + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}