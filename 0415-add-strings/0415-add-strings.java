class Solution {
    public String addStrings(String num1, String num2) {
        String result = "";
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        int num1Index = num1Array.length - 1;
        int num2Index = num2Array.length - 1;
        int curry = 0;
        while (num1Index >= 0 || num2Index >= 0) {
            int num1Num = 0;
            int num2Num = 0;
            if (num1Index >= 0) {
                num1Num = num1Array[num1Index] - '0';
            }
            if (num2Index >= 0) {
                num2Num = num2Array[num2Index] - '0';
            }
            int tmpSum = num1Num + num2Num + curry;
            int num = (tmpSum % 10);
            curry = (tmpSum / 10);
            result = String.valueOf(num) + result;
            num1Index--;
            num2Index--;
        }
        if (curry != 0) {
            result = String.valueOf(curry) + result;
        }
        return result;
    }
}