class Solution {
    public String reverseWords(String s) {
        String curr = "";
        List<String> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                curr = curr + c;
            } else {
                if (curr.length() != 0) {
                    list.add(curr);
                    curr = "";
                }
            }
        }
        if (curr.length() != 0) {
            list.add(curr);
            curr = "";
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.append(list.get(i));
            if (i != 0) {
                ans.append(" ");
            }
        }
        
        return ans.toString();
    }
}