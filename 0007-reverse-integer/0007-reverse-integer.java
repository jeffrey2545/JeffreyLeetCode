class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        
        boolean neg = false;
        if (x < 0) {
            neg = true;
        }
        int result = 0;
        // int max = Integer.MAX_VALUE;
        int max = 214748364;
        int min = -214748364;
        // System.out.println(2147483647);
        // System.out.println(x);
        while (x != 0) {
            int num = x % 10;
            if (result > max || (result == max && num > 7)) {
                return 0;
            }
            if ( result < min || (result == min && num > 7)) {
                return 0;
            }
            int tmp = result * 10 + num;
            result = tmp;
            // System.out.println(result);
            x = x / 10;
        }
        return result;
    }
}
