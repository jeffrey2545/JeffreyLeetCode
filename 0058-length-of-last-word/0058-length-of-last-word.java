class Solution {
    public int lengthOfLastWord(String s) {
        int last = s.length() - 1;
        while (s.charAt(last) == ' ') {
            last--;
        }
        
        int count = 1;
        while (last >= 0 && s.charAt(last) != ' ') {
            count++;
            last--;
        }
        count--;
        return count;
    }
}