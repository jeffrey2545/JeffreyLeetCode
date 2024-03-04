class Solution {
    public String reverseWords(String s) {
        // deal with start and bottom
        int i = 0;
        while (s.charAt(i) == ' ') {
            i++;
        }
        s = s.substring(i, s.length());
        i = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i--;
        }
        s = s.substring(0, i + 1);
        // deal middle space
        List<String> list = new ArrayList<>();
        String word = "";
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (word.length() != 0) {
                    list.add(word);
                    word = "";
                }
            } else {
                word = word + c;
            }
        }
        if (word.length() != 0) {
            list.add(word);
        }
        // reverse
        Collections.reverse(list);
        // create ans
        String ans = "";
        for (int x = 0; x < list.size() - 1; x++) {
            ans = ans + list.get(x) + " ";
        }
        ans = ans + list.get(list.size() - 1);
        return ans;
    }
}