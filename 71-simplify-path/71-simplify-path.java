class Solution {
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : pathArray) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if ("".equals(s) || ".".equals(s)) {
                continue;
            } else {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result;
    }
}