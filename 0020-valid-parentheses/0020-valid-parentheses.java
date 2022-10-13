class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put(')','(');
        map.put('[',']');
        map.put(']','[');
        map.put('{','}');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        char[] sCharArray = s.toCharArray();
        if (sCharArray[0] == '(' || sCharArray[0] == '[' || sCharArray[0] == '{') {
            stack.push(sCharArray[0]);
        } else {
            return false;
        }
        for (int i = 1; i < sCharArray.length; i++) {
            char tmp = sCharArray[i];
            if (tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char peak = stack.peek();
                if (tmp == map.get(peak)) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}