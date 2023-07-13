class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sqr = (long)mid * (long)mid;
            if (sqr > x) {
                right = mid - 1;
            } else if (sqr < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}