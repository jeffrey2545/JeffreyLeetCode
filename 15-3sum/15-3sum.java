class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listresult = new ArrayList<>();
        Set<List<Integer>> setResult= new HashSet<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            
            find(nums, first, i + 1, 0 - first, setResult);
        }
        
        Iterator<List<Integer>> iterator = setResult.iterator();
        while (iterator.hasNext()) {
            listresult.add(iterator.next());
        }
        
        return listresult;
    }
    
    public void find(int[] nums, int first, int start, int target, Set<List<Integer>> setResult) {
        List<Integer> two = new ArrayList<>();
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(first);
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                setResult.add(tmp);
                start++;
                end--;
            }
        }
    }
}