class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
//         if (nums.length <= 1 || nums == null) {
//             return false;
//         }
//         Map<Integer, Integer> map = new HashMap<>();
//         int prefixSum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             int num = nums[i];
//             prefixSum = prefixSum + num;
//             int mod = prefixSum % k;
            
//             if (mod == 0) {
//                 return true;
//             }
//             if (map.containsKey(mod)) {
//                 if (i - map.get(mod) > 1) {
//                     return true;
//                 }
//             } else {
//                 map.put(mod, i);
//             }
//         }
//         return false;
        return test(nums, k);
    }
    public boolean test(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        // corner case: if the very first subarray with first two numbers in array could form the result, we need to 
        // put mod value 0 and index -1 to make it as a true case
        map.put(0, -1);
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            // corner case: k CANNOT be 0 when we use a number mod k
            if (k != 0) {
                curSum = curSum % k;
            }
            if (map.containsKey(curSum)) {
                if (i - map.get(curSum) > 1) {
                    return true;
                }
            }
            else {
                map.put(curSum, i);
            }
        }
        return false;
    }
}