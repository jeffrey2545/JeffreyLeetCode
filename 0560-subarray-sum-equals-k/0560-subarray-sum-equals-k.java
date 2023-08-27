class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int prefix = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix = prefix + nums[i];
            if (prefixMap.containsKey(prefix - k)) {
                result = result + prefixMap.get(prefix - k);
            }
            if (prefixMap.containsKey(prefix)) {
                int origin = prefixMap.get(prefix);
                prefixMap.put(prefix, origin + 1);
            } else {
                prefixMap.put(prefix, 1);
            }
        }
        return result;
    }
}