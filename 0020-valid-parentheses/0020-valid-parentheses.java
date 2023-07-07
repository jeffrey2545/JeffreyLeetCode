class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character bracket : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(bracket);
                continue;
            }
            
            char peek = stack.peek();
            if (closed(bracket, peek)) {
                stack.pop();
            } else {
                stack.push(bracket);
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean closed(char bracket, char peek) {
        if (bracket == ')' && peek == '(') {
            return true;
        }
        if (bracket == ']' && peek == '[') {
            return true;
        }
        if (bracket == '}' && peek == '{') {
            return true;
        }
        return false;
    }
}