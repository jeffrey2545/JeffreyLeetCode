class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put((long) 0,1);

        long prefixSum=0;
        int result = 0;
        for (int i=0; i< nums.length; i++){
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)){
                result = result + map.get(prefixSum - k);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, 1);
            } else {
                map.replace(prefixSum, map.get(prefixSum), map.get(prefixSum) + 1);
            }
        }
        return result;
    }
}