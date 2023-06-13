
public class Position {
  int x;
  int y;
  Position(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        
        int source = image[sr][sc];
        int[] xDelta = {-1, 1, 0, 0};
        int[] yDelta = {0, 0, 1, -1};
        Queue<Position> queue = new ArrayDeque<>();
        HashSet<Position> visited = new HashSet<>();
        image[sr][sc] = color;
        queue.add(new Position(sr, sc));
        visited.add(new Position(sr, sc));
        while (!queue.isEmpty()) {
          int size = queue.size();
          for (int i = 0; i < size; i++) {
            Position curr = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
              int newX = curr.x + xDelta[dir];
              int newY = curr.y + yDelta[dir];

              if ((newX < image.length && newX >= 0) && (newY < image[0].length && newY >= 0)) {
                if (!visited.contains(new Position(newX, newY))) {
                  if (image[newX][newY] == source) {
                    image[newX][newY] = color;
                    queue.add(new Position(newX, newY));
                    visited.add(new Position(newX, newY));
                  }
                }
              }
            }
          }
        }
        return image;
    }
}