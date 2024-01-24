class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int num = 0;
        for (int curr = 0; curr < nums.length; curr++) {
            if (nums[curr] == 0) {
                continue;
            }
            if (num == curr) {
                num++;
                continue;
            }
            nums[num] = nums[curr];
            nums[curr] = 0;
            num++;
        }
    }
}