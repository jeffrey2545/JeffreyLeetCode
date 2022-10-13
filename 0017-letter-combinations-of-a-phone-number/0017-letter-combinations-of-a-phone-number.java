class Solution {
    private final String[] KEYBOARD = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        dfs(digits, "", result, 0);
        return result;
    }

    private void dfs(String digits, String combination, List<String> result, int index) {
        if (index == digits.length()) {
            result.add(combination);
            return;
        }
        int digit = digits.charAt(index) - '0';
        for (int i = 0; i < KEYBOARD[digit].length(); i++) {
            dfs(digits, combination + KEYBOARD[digit].charAt(i), result, index + 1);
        }
    }
}