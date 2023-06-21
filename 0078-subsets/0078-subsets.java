class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> subset, int[] nums, int index) {
      ans.add(new ArrayList<>(subset));

      for (int i = index; i < nums.length; i++) {
        subset.add(nums[i]);
        backtrack(ans, subset, nums, i + 1);
        subset.remove(subset.size() - 1);
      }

      return;
    }
}