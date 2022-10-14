class Solution {
    // public String removeDuplicates(String s, int k) {
    //     boolean smallest = false;
    //     String inputS = s;
    //     String newS = "";
    //     while(!smallest) {
    //         newS = deleteK(inputS, k);
    //         if (newS.equals(inputS)) {
    //             smallest = true;
    //         } else {
    //             inputS = newS;
    //         }
    //     }
    //     return newS;
    // }
    // private String deleteK(String s, int k) {
    //     int count = 1;
    //     char[] sChar = s.toCharArray();
    //     char ch = sChar[0];
    //     for(int i = 1; i < sChar.length; i++) {
    //         if (count == k) {
    //             return s.substring(0, i - k) + s.substring(i, s.length());
    //         }
    //         if (sChar[i] == ch) {
    //             count++;
    //         } else {
    //             count = 1;
    //             ch = sChar[i];
    //         }
    //     }
    //     if (count == k) {
    //         return s.substring(0, sChar.length - k);
    //     }
    //     return s;
    // }

    public String removeDuplicates(String s, int k) {
        Stack<Character> mainStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        
        char[] sChar = s.toCharArray();
        mainStack.push(sChar[0]);
        countStack.push(1);
        for (int i = 1; i < sChar.length; i++) {
            if (mainStack.isEmpty()) {
                mainStack.push(sChar[i]);
                countStack.push(1);
                continue;
            }
            char word = sChar[i];
            char topMain = mainStack.peek();
            int count = countStack.peek();

            if (word == topMain) {
                count++;
                countStack.pop();
                countStack.push(count);
            } else {
                mainStack.push(word);
                countStack.push(1);
            }

            if (count == k) {
                mainStack.pop();
                countStack.pop();
            }
        }
        String result = "";
        while (!mainStack.isEmpty()) {
            char curChar = mainStack.pop();
            int num = countStack.pop();
            for (int i = 0; i < num; i++) {
                result = String.valueOf(curChar) + result;
            }
        }

        return result;
    }
}

/*
"aa"
k = 3
*/
// deeedbbcccbdaa

// stack : d e d
// check : 1 2 1
// k = 3