class Solution {
    public int minimumCost(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>(); // vertex -> neighbors -> [neighbor, cost]
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<int[]>());
        }
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            int cost = connection[2];
            
            List<int[]> xNeighbors = graph.get(x);
            int[] arr1 = {y, cost};
            xNeighbors.add(arr1);
            graph.put(x, xNeighbors);
            
            List<int[]> yNeighbors = graph.get(y);
            int[] arr2 = {x, cost};
            yNeighbors.add(arr2);
            graph.put(y, yNeighbors);
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Set<Integer> mst = new HashSet<>();
        int costs = 0;
        heap.add(new int[] {1, 1, 0});
        while (!heap.isEmpty()) {
            int[] min = heap.poll();
            int vertex = min[0];
            int target = min[1];
            int cost = min[2];
            
            if (mst.contains(target)) {
                continue;
            }
            mst.add(target);
            costs = costs + cost;
            for (int[] arr : graph.get(target)) {
                heap.add(new int[] {target, arr[0], arr[1]});
            }
        }
        
        if (mst.size() != n) {
            return -1;
        } else {
            return costs;
        }
    }
}