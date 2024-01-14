class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        Map<Integer, Integer> leftPrefix = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
            leftPrefix.put(i, product);
        }
        product = 1;
        Map<Integer, Integer> rightPrefix = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            product = product * nums[i];
            rightPrefix.put(i, product);
        }
        
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            int left = 1, right = 1;
            if (leftPrefix.containsKey(i - 1)) {
                left = leftPrefix.get(i - 1);
            }
            if (rightPrefix.containsKey(i + 1)) {
                right = rightPrefix.get(i + 1);
            }
            ans[i] = left * right;
        }
        return ans;
    }
}