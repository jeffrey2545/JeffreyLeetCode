class Solution {
    public String capitalizeTitle(String title) {
        List<String> list = new ArrayList<>();
        String tmp = "";
        for (int i = 0; i < title.length(); i++) {
            if (title.charAt(i) == ' ') {
                list.add(tmp);
                tmp = "";
            } else {
                char c = title.charAt(i);
                int intC = (int)c;
                if (intC >= 65 && intC <= 90) {
                    int newIntC = intC + 32;
                    tmp = tmp + (char)newIntC;
                } else {
                    tmp = tmp + (char)intC;
                }
            }
        }
        list.add(tmp);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (word.length() <= 2) {
                result.append(word);
                if (i != list.size() - 1) {
                    result.append(" ");
                }
            } else {
                char[] ch = word.toCharArray();
                ch[0] = Character.toUpperCase(ch[0]);
                result.append(String.valueOf(ch));
                if (i != list.size() - 1) {
                    result.append(" ");
                }
            }
        }
        return result.toString();
    }
}