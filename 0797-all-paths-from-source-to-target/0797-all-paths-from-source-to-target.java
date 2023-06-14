class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, 0, path, ans);
        return ans;
    }
    
    public void dfs(int[][] graph, int curr, List<Integer> path, List<List<Integer>> ans) {
        if (curr == graph.length - 1) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        
        int[] nexts = graph[curr];
        for (int next : nexts) {
            path.add(next);
            dfs(graph, next, path, ans);
            path.remove(path.size() - 1);
        }
        return;
    }
}