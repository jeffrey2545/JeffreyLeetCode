class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return palindrome(s, left + 1, right) || palindrome(s, left, right - 1);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
    
    public boolean palindrome(String string, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}