class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while (right < fruits.length) {
            if (left < fruits.length && (map.size() < 2 || map.containsKey(fruits[right]))) {
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
                ans = Math.max(ans, right - left + 1);
                right++;
            } else {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) <= 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
        }
        return ans;
    }
}
// 1,2,3,2,2,4,2
// leftPair = (2, 3)
// rightPair = (3, 1)
// ans = 4