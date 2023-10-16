class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> sortedList = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sortedList.add(num);
            }
        }
        for (int i = 0; i < sortedList.size(); i++) {
            nums[i] = sortedList.get(i);
        }
        return set.size();
    }
}