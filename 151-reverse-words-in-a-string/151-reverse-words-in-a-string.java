class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Stack<String> stack = new Stack<String>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            char ch = s.charAt(left);
            if ((word.length() != 0) && (ch == ' ')) {
                stack.push(word.toString());
                word.setLength(0);
            } else if (ch != ' ') {
                word.append(ch);
            }
            ++left;
        }
        stack.push(word.toString());

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (!stack.isEmpty()) {
                result.append(pop + " ");
            } else {
                result.append(pop);
            }
        }

        return result.toString();
    }
}