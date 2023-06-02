class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // find a divisor
        // // test str1
        // // test str2
        String result = "";
        StringBuilder temp = new StringBuilder();
        // find a temp
        // if it pass both str1 and str2, result = temp
        // find the next temp
        int pos = 0;
        int pos1 = 0, pos2 = 0;
        while (pos < str1.length() && pos < str2.length()) {
            if (str1.charAt(pos) == str2.charAt(pos)) {
                temp.append(str1.charAt(pos));
                pos++;
                
                if (checkDivisor(str1, temp.toString()) && checkDivisor(str2, temp.toString())) {
                    result = temp.toString();
                }
            } else {
                break;
            }
        }
        return result;
    }
    
    public boolean checkDivisor(String str, String divisor) {
        int x = 0, y = 0;
        while (x < str.length()) {
            if (str.charAt(x) != divisor.charAt(y)) {
                return false;
            }
            x++;
            if (y == divisor.length() - 1) {
                y = 0;
            } else {
                y++;
            }
        }
        if (y != 0) {
            return false;
        }
        return true;
    }
}