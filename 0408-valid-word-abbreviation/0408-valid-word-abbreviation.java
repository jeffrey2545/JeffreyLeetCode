class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        // deal abbr
        List<String> list = new ArrayList<>();
        for (int i = 0; i < abbr.length(); i++) {
            if (Character.isLetter(abbr.charAt(i))) {
                String c = String.valueOf(abbr.charAt(i));
                list.add(c);
            } else {
                String num = "";
                while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                    num = num + abbr.charAt(i);
                    i++;
                }
                i--;
                // check num valuable
                int intNum = Integer.valueOf(num);
                String strNum = Integer.toString(intNum);
                if (strNum.equals(num)) {
                    if (intNum == 0) {
                        return false;
                    }
                    list.add(num);
                } else {
                    return false;
                }
            }
        }
        // check word
        int w = 0;
        int l = 0;
        while (w < word.length() && l < list.size()) {
            char c = word.charAt(w);
            String s = list.get(l);
            if (Character.isDigit(s.charAt(0))) {
                int pass = Integer.valueOf(s);
                w = w + pass;
                l++;
            } else {
                if (c != s.charAt(0)) {
                    return false;
                } else {
                    w++;
                    l++;
                }
            }
        }
        if (w == word.length() && l == list.size()) {
            return true;
        } else {
            return false;
        }
    }
}