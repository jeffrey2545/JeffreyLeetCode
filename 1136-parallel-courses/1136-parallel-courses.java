class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        // init
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n + 1];
        for (int[] relation : relations) {
            int prevCourse = relation[0];
            int nextCourse = relation[1];
            
            List<Integer> list;
            if (map.containsKey(prevCourse)) {
                list = map.get(prevCourse);
            } else {
                list = new ArrayList<>();
            }
            list.add(nextCourse);
            
            map.put(prevCourse, list);
            indegree[nextCourse]++;
        }
        
        // topological
        Queue<Integer> queue = new ArrayDeque<>();
        // get indegree = 0
        for (int course = 1; course < n + 1; course++) {
            if (indegree[course] == 0) {
                queue.add(course);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int course = queue.poll();
                visited.add(course);
                if (!map.containsKey(course)) {
                    continue;
                }
                List<Integer> list = map.get(course);
                for (int nextCourse : list) {
                    indegree[nextCourse]--;
                    if (indegree[nextCourse] <= 0) {
                        queue.add(nextCourse);
                    }
                }
            }
            ans++;
        }
        
        if (visited.size() == n) {
            return ans;
        } else {
            return -1;
        }
    }
}