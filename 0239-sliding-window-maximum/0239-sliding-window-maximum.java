class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // initialize
        TreeMap<Integer, Integer> map = new TreeMap<>(); // num, count
        int left = 0, right = k - 1;
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        
        // Initialize the first k elements into the map
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ans[index++] = map.lastKey();
        
        while (right < nums.length - 1) {
            // remove left from map, add right to map
            if (map.get(nums[left]) == 1) {
                map.remove(nums[left]);
            } else {
                map.put(nums[left], map.get(nums[left]) - 1);
            }
            
            right++;
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            // get the max from map, add it into ans
            ans[index++] = map.lastKey();
            
            // move left
            left++;
        }
        // return ans
        return ans;
    }
}
