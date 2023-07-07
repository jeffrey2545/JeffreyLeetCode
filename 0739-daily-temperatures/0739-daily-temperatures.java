class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
          int temperature = temperatures[i];
          while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
            int index = stack.pop();
            ans[index] = i - index;
          }
          stack.push(i);
        }

        while (!stack.isEmpty()) {
          int index = stack.pop();
          ans[index] = 0;
        }
        return ans;
    }
}