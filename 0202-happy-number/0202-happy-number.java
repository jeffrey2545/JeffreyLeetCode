class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return happy(n, set);
    }
    
    public boolean happy(int n, Set<Integer> set) {
        if (set.contains(n)) {
            return false;
        } else {
            set.add(n);
            int newN = cal(n);
            if (newN == 1) {
                return true;
            }
            // set.add(newN);
            return happy(newN, set);
        }
    }
    
    public int cal(int n) {
        int sum = 0;
        while (n >= 10) {
            int r = n % 10;
            sum = sum + (r * r);
            n = n / 10;
        }
        sum = sum + (n * n);
        return sum;
    }
}