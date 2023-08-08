class Solution {
    public boolean checkPossibility(int[] nums) {
        int pre = 0, curr = 0, next = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curr = nums[i];
            next = nums[i + 1];
            
            if (i == 0) {
              pre = curr;
            }

            if (next >= curr) {
                pre = curr;
                continue;
            }

            if (count > 0) {
              return false;
            }

            if (i == 0) {
                nums[i] = next;
                pre = curr;
                count++;
                continue;
            }

            if (next >= pre) {
                nums[i] = next;
            } else {
                nums[i + 1] = curr;
            }
            pre = curr;
            count++;
        }
        return true;
    }
}