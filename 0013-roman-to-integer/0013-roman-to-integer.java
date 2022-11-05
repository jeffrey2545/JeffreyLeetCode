class Solution {
    public int romanToInt(String s) {
        int result = 0;
        if (s.indexOf("IV") != -1) {
            result = result - 2;
        }
        if (s.indexOf("IX") != -1) {
            result = result - 2;
        }
        if (s.indexOf("XL") != -1) {
            result = result - 20;
        }
        if (s.indexOf("XC") != -1) {
            result = result - 20;
        }
        if (s.indexOf("CD") != -1) {
            result = result - 200;
        }
        if (s.indexOf("CM") != -1) {
            result = result - 200;
        }
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            char roman = sArr[i];
            switch (roman) {
                case 'M':
                    result = result + 1000;
                    break;
                case 'D':
                    result = result + 500;
                    break;
                case 'C':
                    result = result + 100;
                    break;
                case 'L':
                    result = result + 50;
                    break;
                case 'X':
                    result = result + 10;
                    break;
                case 'V':
                    result = result + 5;
                    break;
                case 'I':
                    result = result + 1;
                    break;
            }
        }
        return result;
    }
}