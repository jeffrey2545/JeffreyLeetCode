class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // int[] inDegree = new int[rooms.size()];
        // Arrays.fill(inDegree, 0);
        // for (int room = 0; room < rooms.size(); room++) {
        //     List<Integer> keys = rooms.get(room);
        //     for (int key : keys) {
        //         // if (key == room) {
        //         //     continue;
        //         // }
        //         inDegree[key]++;
        //     }
        // }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        // for (int room = 0; room < rooms.size(); room++) {
        //     if (inDegree[room] == 0) {
        //         queue.add(room);
        //     }
        // }
        
        // int count = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            // count++;
            for (int key : rooms.get(room)) {
                if (key == room) {
                    continue;
                }
                if (set.contains(key)) {
                    continue;
                }
                // inDegree[key]--;
                queue.add(key);
                set.add(key);
                // if (inDegree[key] == 0) {
                //     queue.add(key);
                // }
            }
        }
        
        return set.size() == rooms.size();
    }
}