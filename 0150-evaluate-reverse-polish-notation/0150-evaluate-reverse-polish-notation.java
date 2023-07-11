class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = operation(num1, num2, token);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
    
    private int operation(int num1, int num2, String token) {
        if (token.equals("+")) {
            return num2 + num1;
        } else if (token.equals("-")) {
            return num2 - num1;
        } else if (token.equals("*")) {
            return num2 * num1;
        } else {
            return num2 / num1;
        }
    }
}