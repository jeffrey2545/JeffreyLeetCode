class Solution {
    public int pivotInteger(int n) {
        // build map
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
            map.put(i, sum);
        }
        
        // interate
        for (int i = 1; i <= n; i++) {
            int left = map.get(i);
            int right = i + (sum - left);
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
// 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.

// 1 = 1 35
// 2 = 3 33
// 3 = 6 30
// 4 = 10 26
// 5 = 15 21
// 6 = 21 15
// 7 = 28 8
// 8 = 36 0