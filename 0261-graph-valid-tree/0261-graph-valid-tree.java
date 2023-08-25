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
    
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false;
            }
        }
        int parent = uf.find(0);
        for (int node = 1; node < n; node++) {
            int curr_par = uf.find(node);
            if (curr_par != parent) {
                return false;
            }
        }
        return true;
    }
}