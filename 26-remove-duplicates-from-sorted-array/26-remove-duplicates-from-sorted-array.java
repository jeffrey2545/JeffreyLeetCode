class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int newPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            } else {
                set.add(nums[i]);
                nums[newPos++] = nums[i];
            }
        }
        return set.size();
    }
}