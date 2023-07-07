class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int max = 0;
        for (Integer num : set) {
            // check is the begin
            if (set.contains(num - 1)) {
                continue;
            }
            int start = num;
            int count = 0;
            while (set.contains(start)) {
                count++;
                start++;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}