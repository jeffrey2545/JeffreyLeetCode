class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            graph.put(i, list);
        }
        Arrays.fill(inDegree, 0);
        
        for (int[] prerequisite : prerequisites) {
            int target = prerequisite[0];
            int pre = prerequisite[1];
            
            inDegree[target]++;
            List<Integer> nexts = graph.get(pre);
            nexts.add(target);
            graph.replace(pre, graph.get(pre), nexts);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ans.add(course);
            List<Integer> nexts = graph.get(course);
            for (int next : nexts) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        
        if (ans.size() != numCourses) {
            return new int[0];
        }
        int[] ansArr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
}