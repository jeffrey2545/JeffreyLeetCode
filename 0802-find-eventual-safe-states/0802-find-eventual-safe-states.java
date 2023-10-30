class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> terminals = new HashSet<>();
        int[] memo = new int[graph.length];
        Arrays.fill(memo, 2);
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                terminals.add(i);
                memo[i] = 1;
            }
        }
        for (int i = 0; i < graph.length; i++) {
            boolean[] visited = new boolean[graph.length];
            if (isSafe(graph, terminals, i, memo, visited)) {
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean isSafe(int[][] graph, Set<Integer> terminals, int root, int[] memo, boolean[] visited) {
        if (memo[root] != 2) {
            return memo[root] == 1;
        }
        if (visited[root]) {
            return false;
        }
        if (terminals.contains(root)) {
            return true;
        }
        int[] nexts = graph[root];
        visited[root] = true;
        for (int next : nexts) {
            if (!isSafe(graph, terminals, next, memo, visited)) {
                memo[root] = 0;
                return false;
            }
        }
        memo[root] = 1;
        return true;
    }
}

// 0 -> 1, 2
// 1 -> 2, 3
// 2 -> 5
// 3 -> 0
// 4 -> 5
// 5 -> null
// 6 -> null

// 5 6 are terminal node
