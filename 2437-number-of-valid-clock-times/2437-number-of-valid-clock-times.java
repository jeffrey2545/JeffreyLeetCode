class Solution {
    public int countTime(String time) {
        int ans = 1;
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            ans = ans * 24;
        }
        
        if (time.charAt(0) == '?' && time.charAt(1) != '?') {
            if (Integer.valueOf(String.valueOf(time.charAt(1))) >= 4) {
                ans = ans * 2;
            } else if (Integer.valueOf(String.valueOf(time.charAt(1))) < 4) {
                ans = ans * 3;
            }
        }
        
        if (time.charAt(0) != '?' && time.charAt(1) == '?') {
            if (Integer.valueOf(String.valueOf(time.charAt(0))) >= 2) {
                ans = ans * 4;
            } else if (Integer.valueOf(String.valueOf(time.charAt(0))) < 2) {
                ans = ans * 10;
            }
        }
        
        if (time.charAt(3) == '?') {
            ans = ans * 6;
        }
        
        if (time.charAt(4) == '?') {
            ans = ans * 10;
        }
        
        return ans;
    }
}
// 3, 4, 6, 10
// 00, 01, 02, 03, 04, 05, 06, 07, 08, 09
// 10, 11, ..., 19
// 20, 21, 22, 23