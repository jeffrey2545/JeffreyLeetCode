class Solution {
    public static final int UNnodeColorED = 0;
    public static final int RED = 1;
    public static final int GREEN = 2;
    public boolean isBipartite(int[][] graph) {
        int graph_count = graph.length;
        int[] nodeColor = new int[graph_count];
        
        for (int node = 0; node < graph_count; node++) {
            if (nodeColor[node] == UNnodeColorED) {
                if (!dfs(node, RED, graph, nodeColor)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean dfs(int node, int color, int[][] graph, int[] nodeColor) {
        nodeColor[node] = color;
        int neighborColor = (color == RED) ? GREEN : RED;
        
        for (int neighbor : graph[node]) {
            if (nodeColor[neighbor] == UNnodeColorED) {
                if (!dfs(neighbor, neighborColor, graph, nodeColor)) {
                    return false;
                }
            } else if (nodeColor[neighbor] != neighborColor) {
                return false;
            }
        }
        
        return true;
    }
}