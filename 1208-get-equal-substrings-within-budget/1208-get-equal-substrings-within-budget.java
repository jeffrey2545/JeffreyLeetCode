class Solution {
    public int equalSubstring(String s, String t, int k) {
        int n = s.length();
        int left = 0;
        int right;
        for (right = 0; right < n; right++) {
            k -= Math.abs(s.charAt(right) - t.charAt(right));
            if (k < 0) {
                k += Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
        }
        return right - left;
    }
}