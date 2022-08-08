class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ASCII = (int)s.charAt(i);
            if (ASCII >= 97 && ASCII <= 122) {
                newS.append((char)ASCII);
            } else if (ASCII >= 65 && ASCII <= 90) {
                int newASCII = ASCII + 32;
                newS.append((char)newASCII);
            } else if (ASCII >= 48 && ASCII <= 57) {
                newS.append((char)ASCII);
            }
        }
        
        String sString = newS.toString();
        int left = 0, right = sString.length() - 1;
        while (left < right) {
            if (sString.charAt(left) != sString.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}