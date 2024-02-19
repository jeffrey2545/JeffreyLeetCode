class Solution {
    Map<Integer, Integer> memo;
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        memo = new HashMap<>();
        return dfs(0, arr, k);
    }
    
    public int dfs(int index, int[] arr, int k) {
        if (index >= arr.length) {
            return 0;
        }
        
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        int tmpSum = 0;
        int tmpMax = -1;
        int maxSum = 0;
        for (int i = index; i < k + index && i < arr.length; i++) {
            if (tmpMax < arr[i]) {
                tmpMax = arr[i];
            }
            tmpSum = tmpMax * (i - index + 1);
            
            maxSum = Math.max(maxSum, tmpSum + dfs(i + 1, arr, k));
        }
        // System.out.println(maxSum);
        memo.put(index, maxSum);
        return maxSum;
    }
}
// arr = [1,15,7,9,2,5,10], k = 3
// start
// 1 => 1
// 30 => 2
// 45 => 3