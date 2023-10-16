class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(nums[0]);
        for (int num : nums) {
            int lastInt = sortedList.get(sortedList.size() - 1);
            if (num != lastInt) {
                sortedList.add(num);
            }
        }
        for (int i = 0; i < sortedList.size(); i++) {
            nums[i] = sortedList.get(i);
        }
        return sortedList.size();
    }
}