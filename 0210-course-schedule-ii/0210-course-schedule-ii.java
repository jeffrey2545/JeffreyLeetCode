class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Make a graph
        // Make a indegree
        int[] indegree = new int[numCourses];
        HashMap<Integer, HashSet> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[1];
            int target = prerequisite[0];
            HashSet<Integer> set = graph.get(pre);
            set.add(target);
            graph.put(pre, set);
            indegree[target]++;
        }
        // topological
        int[] order = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            order[index] = pre;
            index++;
            HashSet<Integer> set = graph.get(pre);
            for (Integer target : set) {
                indegree[target]--;
                if (indegree[target] == 0) {
                    queue.add(target);
                }
            }
        }
        // return
        if (index != numCourses) {
            int[] empty = {};
            return empty;
        }
        return order;
    }
}