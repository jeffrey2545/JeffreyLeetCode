class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        Stack<Character> stack = new Stack<>();
        boolean[] exist = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (exist[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek() - 'a']) {
                char pop = stack.pop();
                exist[pop - 'a'] =false;
            }
            stack.push(c);
            exist[c - 'a'] = true;
        }
        
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}