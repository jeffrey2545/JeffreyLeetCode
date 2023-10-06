class Solution {
    public int trap(int[] height) {
        int ans = 0;
        
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            int num = height[i];
            if (num >= max) {
                max = num;
                maxIndex = i;
            }
        }
        
        int left = height[0];
        for (int i = 1; i < maxIndex; i++) {
            int curr = height[i];
            if (curr >= left) {
                left = curr;
                continue;
            }
            ans = ans + Math.min(left, max) - curr;
        }
        int right = height[height.length - 1];
        for (int i = height.length - 2; i > maxIndex; i--) {
            int curr = height[i];
            if (curr >= right) {
                right = curr;
                continue;
            }
            ans = ans + Math.min(right, max) - curr;
        }
        
        return ans;
    }
}