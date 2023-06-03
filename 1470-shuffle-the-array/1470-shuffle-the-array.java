class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        
        int x = 0, y = 0;
        for (int i = 0; i < 2 * n; i = i + 2) {
            ans[i] = nums[y];
            y++;
            if (i != 0) {
                ans[i - 1] = nums[x + n];
                x++;
            }
        }
        ans[ans.length - 1] = nums[nums.length - 1];
        
        return ans;
    }
}