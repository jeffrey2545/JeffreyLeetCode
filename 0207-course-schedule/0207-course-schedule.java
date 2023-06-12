class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // calcultae the in-degree
        // make the map
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            List<Integer> targets = new ArrayList<>();
            map.put(i, targets);
        }
        
        for (int[] prerequisite : prerequisites) {
            int target = prerequisite[0];
            int pre = prerequisite[1];
            inDegree[target]++;
            
            List<Integer> targets = map.get(pre);
            targets.add(target);
            map.replace(pre, map.get(pre), targets);
        }
        // put every degree = 0 into queue
        Queue<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) {
            int prerequisite = inDegree[course];
            if (prerequisite == 0) {
                queue.add(course);
            }
        }
        // while queue
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            List<Integer> targets = map.get(course);
            for (int i = 0; i < targets.size(); i++) {
                int target = targets.get(i);
                inDegree[target]--;
                if (inDegree[target] == 0) {
                    queue.add(target);
                }
            }
        }
        // check if the count == numCourses
        
        return count == numCourses;
    }
}