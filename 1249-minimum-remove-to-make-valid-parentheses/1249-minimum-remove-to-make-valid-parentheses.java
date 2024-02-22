class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        // remove right
        int check = 0;
        for (char c : s.toCharArray()) {
            if (check == 0 && c == ')') {
                continue;
            }
            if (c == '(') {
                check++;
            }
            if (c == ')') {
                check--;
            }
            stack.add(c);
        }
        // remove left
        check = 0;
        String ans = "";
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (check == 0 && c == '(') {
                continue;
            }
            if (c == ')') {
                check++;
            }
            if (c == '(') {
                check--;
            }
            ans = c + ans;
        }
        
        return ans;
    }
}