class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> heap1 = new PriorityQueue<>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums1) {
            heap1.add(num);
        }
        for (int num : nums2) {
            heap2.add(num);
        }
        
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            ans = ans + (heap1.poll() * heap2.poll());
        }
        
        return ans;
    }
}