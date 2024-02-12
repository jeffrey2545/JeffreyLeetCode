class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer major = null;
        for (int num : nums) {
            if (count == 0) {
                major = num;
            }
            count += (num == major) ? 1 : -1;
        }
        return major;
    }
}