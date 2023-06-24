class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), new HashSet<>(), nums);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> order, HashSet<Integer> visited, int[] nums) {
        if (order.size() == nums.length) {
            ans.add(new ArrayList<>(order));
            return;
        }
        
        for (int num : nums) {
            if (visited.contains(num)) {
                continue;
            }
            
            order.add(num);
            visited.add(num);
            dfs(ans, order, visited, nums);
            visited.remove(num);
            order.remove(order.size() - 1);
        }
    }
}