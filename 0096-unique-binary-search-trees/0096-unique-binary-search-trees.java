class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
      if (n == 0 || n == 1) {
        return 1;
      }
      int sum = 0;
      for (int i = 1; i <= n; ++i) {
        if (!map.containsKey(i - 1)) {
          map.put(i - 1, numTrees(i - 1));
        }
        if (!map.containsKey(n - i)) {
          map.put(n - i, numTrees(n - i));
        }
        sum += map.get(i - 1) * map.get(n - i);
      }
      return sum;
    }
}