class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<int[], List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            int[] curr = bombs[i];
            List<int[]> detonates = new ArrayList<>();
            for (int j = 0; j < bombs.length; j++) {
                if (j == i) {
                    continue;
                }
                int[] next = bombs[j];
                long distance = (long)(curr[0] - next[0])*(curr[0] - next[0]) + (long)(curr[1] - next[1])*(curr[1] - next[1]);
                if (distance <= (long)curr[2]*curr[2]) {
                    detonates.add(next);
                }
            }
            graph.put(curr, detonates);
        }
        
        int ans = 0;
        for (int[] bomb : bombs) {
            ans = Math.max(ans, dfs(new HashSet<>(), graph, bomb));
        }
        return ans;
    }
    
    public int dfs(Set<int[]> visited, Map<int[], List<int[]>> graph, int[] curr) {
        visited.add(curr);
        
        int count = 1;
        for (int[] next : graph.get(curr)) {
            if (!visited.contains(next)) {
                count = count + dfs(visited, graph, next);
            }
        }
        
        return count;
    }
}