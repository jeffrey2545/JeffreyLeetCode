class Solution {
    public int swimInWater(int[][] grid) {
        int size = grid.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        heap.add(new int[] {0, 0});
        boolean[][] visited = new boolean[size][size];
        int[] delX = new int[] {1, -1, 0, 0};
        int[] delY = new int[] {0, 0, 1, -1};
        int time = 0;
        
        while (!heap.isEmpty()) {
            while (time >= grid[heap.peek()[0]][heap.peek()[1]]) {// check every new land
                int[] newLand = heap.poll();
                
                if (newLand[0] == size - 1 && newLand[1] == size - 1) {// reach end
                    return time;
                }
                
                visited[newLand[0]][newLand[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int[] nextLand = new int[] {newLand[0] + delX[i], newLand[1] + delY[i]};
                    
                    if (nextLand[0] < 0 || nextLand[0] >= size) {
                        continue;
                    }
                    if (nextLand[1] < 0 || nextLand[1] >= size) {
                        continue;
                    }
                    if (visited[nextLand[0]][nextLand[1]]) {
                        continue;
                    }
                    
                    heap.add(nextLand);
                }
            }
            time++;
        }
        return 0;
    }
}