class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = count + palidrome(s, i, false);
            count = count + palidrome(s, i, true);
        }
        return count + s.length();
    }
    
    public int palidrome(String s, int i, boolean mid) {
        int left, right;
        int count = 0;
        if (mid) {
            left = i;
            right = i + 1;
        } else {
            left = i - 1;
            right = i + 1;
        }

        while ((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {
            count++;
            left--;
            right++;
        }
        
        return count;
    }
}