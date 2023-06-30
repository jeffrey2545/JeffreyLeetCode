class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];
        nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        nums2 = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(subRob(nums1), subRob(nums2));
    }
    
    public int subRob(int[] nums) {
        int[] money = new int[nums.length];
          money[0] = nums[0];
          money[1] = Math.max(nums[0], nums[1]);

          for (int left = 2; left < nums.length; left++) {
            int rob = money[left - 2] + nums[left];
            int noRob = money[left - 1];
            money[left] = Math.max(rob, noRob);
          }

          return money[money.length - 1];
    }
}