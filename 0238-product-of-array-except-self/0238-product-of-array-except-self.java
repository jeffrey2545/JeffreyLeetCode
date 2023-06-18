class Solution {
    public int[] productExceptSelf(int[] nums) {
        int frontProduct = 1;
        HashMap<Integer, Integer> frontPrefix = new HashMap<>();
        // 從頭數過來前幾項的積
        for (int i = 0; i < nums.length; i++) {
            frontProduct = frontProduct * nums[i];
            frontPrefix.put(i + 1, frontProduct);
        }
        
        int backProduct = 1;
        int back = 1;
        HashMap<Integer, Integer> backPrefix = new HashMap<>();
        // 從尾數過來後幾項的積
        for (int i = nums.length - 1; i >= 0; i--) {
            backProduct = backProduct * nums[i];
            backPrefix.put(back, backProduct);
            back++;
        }
        
        int[] ans = new int[nums.length];
        back = nums.length - 1;
        for (int front = 0; front < nums.length; front++) {
            int frontV = 1, backV = 1;
            if (frontPrefix.containsKey(front)) {
                frontV = frontPrefix.get(front);
            }
            if (backPrefix.containsKey(back)) {
                backV = backPrefix.get(back);
            }
            ans[front] = frontV * backV;
            back--;
        }
        
        return ans;
    }
}