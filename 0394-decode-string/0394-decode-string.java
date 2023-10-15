class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.add(c);
                continue;
            }
            String base = "";
            while (stack.peek() != '[') {
                base = stack.pop() + base;
            }
            stack.pop();
            String numS = "";
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                numS = stack.pop() + numS;
            }
            int num = Integer.valueOf(numS);
            for (int i = 0; i < num; i++) {
                for (char ch : base.toCharArray()) {
                    stack.add(ch);
                }
            }
        }
        
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}