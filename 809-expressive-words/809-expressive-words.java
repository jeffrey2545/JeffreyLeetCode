class Solution {
    public int expressiveWords(String s, String[] words) {
        int result = 0;
        
        for (int i = 0; i < words.length; i++) {
            result = result + isStretchy(s, words[i]);
        }
        
        return result;
    }
    
    public int isStretchy(String stretchy, String regular) {
        int regPoint = 0;
        char[] regChar = regular.toCharArray();
        char regtmp = regChar[0];
        int regCount = 0;
        
        int strPoint = 0;
        char[] strChar = stretchy.toCharArray();
        char strtmp = strChar[0];
        int strCount = 0;
        while (strPoint < stretchy.length() && regPoint < regular.length()) {
            regtmp = regChar[regPoint];
            regCount = 0;
            strtmp = strChar[strPoint];
            strCount = 0;
            while (regPoint < regular.length() && regChar[regPoint] == regtmp) {
                regPoint++;
                regCount++;
            }
            while (strPoint < stretchy.length() && strChar[strPoint] == strtmp) {
                strPoint++;
                strCount++;
            }

            if (regtmp != strtmp) {
                return 0;
            }
            if (strCount >= regCount && strCount != 2) {
                continue;
            } else if (strCount == 2 && regCount == 2) {
                continue;
            } else {
                return 0;
            }
        }
        
        if (strPoint < stretchy.length() || regPoint < regular.length()) {
            return 0;
        }
        
        return 1;
    }
}