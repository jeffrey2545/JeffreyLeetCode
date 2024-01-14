class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        
        char current = chars[0];
        int count = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == current) {
                count++;
            } else {
                ans.append(current);
                current = chars[i];
                if (count != 1) {
                    ans.append(Integer.toString(count));
                }
                count = 1;
            }
        }
        ans.append(current);
        if (count != 1) {
            ans.append(Integer.toString(count));
        }
        
        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.toString().toCharArray()[i];
        }
        return ans.length();
    }
}