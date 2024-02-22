class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            count++;
        }
        left = left << count;
        return left;
    }
}
// 1 =    1
// 2 =   10
// 3 =   11
// 4 =  100
// 5 =  101
// 6 =  110
// 7 =  111
// 8 = 1000
// 9 = 1001