class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(k, n, 1, path, result);
        return result;
    }
    
    public void dfs(int count, int remain, int index, List<Integer> path, List<List<Integer>> result) {
        if (count == 0) {
            if (remain == 0) {
                result.add(new ArrayList<>(path));
                return;
            } else {
                return;
            }
        }
        
        for (int num = index; num <= 9; num++) {
            if (remain - num < 0) {
                break;
            }
            path.add(num);
            // System.out.println(path);
            dfs(count - 1, remain - num, num + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}