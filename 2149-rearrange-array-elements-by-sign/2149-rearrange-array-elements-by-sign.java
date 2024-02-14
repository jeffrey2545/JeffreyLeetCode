class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int odd = 1;
        int even = 0;
        for (int num : nums) {
            if (num > 0) {
                ans[even] = num;
                even = even + 2;
            } else {
                ans[odd] = num;
                odd = odd + 2;
            }
        }
        return ans;
    }
}