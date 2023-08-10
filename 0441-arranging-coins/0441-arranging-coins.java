class Solution {
    public int arrangeCoins(int n) {
        long start = 1, end = n;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long counts = (1 + mid) * mid / 2;
            if (counts > n) {
                end = mid;
            } else if (counts < n) {
                start = mid;
            } else {
                return (int)mid;
            }
        }
        long countsStart = (1 + start) * start / 2;
        long countsEnd = (1 + end) * end / 2;
        if (n > countsEnd) {
            return (int)end;
        }
        return (int)start;
    }
}