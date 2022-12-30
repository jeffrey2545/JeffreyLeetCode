class Solution {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        if (five(three(two(n))) == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public int two(int n) {
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n;
    }
    
    public int three(int n) {
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n;
    }
    
    public int five(int n) {
        while (n % 5 == 0) {
            n = n / 5;
        }
        return n;
    }
}