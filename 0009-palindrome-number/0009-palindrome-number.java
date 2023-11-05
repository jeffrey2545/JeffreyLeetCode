class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        List<Integer> list = new ArrayList<>();
        helper(x, list);
        
        if (list.size() == 1) {
            return true;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public void helper(int x, List<Integer> list) {
        if (x < 10) {
            list.add(x);
            return;
        }
        
        int remain = x % 10;
        x = x / 10;
        list.add(remain);
        helper(x, list);
        return;
    }
}