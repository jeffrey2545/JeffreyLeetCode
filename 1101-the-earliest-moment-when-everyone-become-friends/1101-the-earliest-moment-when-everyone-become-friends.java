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
    
    public int earliestAcq(int[][] logs, int n) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        for (int[] log : logs) {
            heap.add(log);
        }
        
        UF uf = new UF(n);
        while (!heap.isEmpty()) {
            int[] log = heap.poll();
            int timestamp = log[0];
            int x = log[1];
            int y = log[2];
            if (uf.union(x, y)) {
                n--;
            }
            if (n == 1) {
                return timestamp;
            }
        }
        return -1;
    }
}