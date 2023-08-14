class Solution {
    class UF {
        int[] parent;
        int[] rank;
        
        public UF(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int a) {
            if (parent[a] == a) {
                return a;
            }
            parent[a] = find(parent[a]);
            return parent[a];
        }
        
        public boolean union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            
            if (aParent == bParent) {
                return false;
            }
            
            if (rank[aParent] > rank[bParent]) {
                parent[bParent] = aParent;
            } else if (rank[aParent] < rank[bParent]) {
                parent[aParent] = bParent;
            } else {
                parent[aParent] = bParent;
                rank[bParent]++;
            }
            
            return true;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n + 1);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            uf.union(a, b);
        }
        Set<Integer> set = new HashSet<>();
        for (int node = 0; node < n; node++) {
            int parent = uf.find(node);
            // System.out.println(parent);
            set.add(parent);
        }
        return set.size();
    }
}