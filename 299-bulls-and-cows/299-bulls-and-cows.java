class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        StringBuilder newGuessB = new StringBuilder();
        char[] secretChA = secret.toCharArray();
        char[] guessChA = guess.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < secretChA.length; i++) {
            if (secretChA[i] == guessChA[i]) {
                A++;
                continue;
            } else {
                if (map.containsKey(secretChA[i])) {
                    map.replace(secretChA[i], map.get(secretChA[i]), map.get(secretChA[i]) + 1);
                } else {
                    map.put(secretChA[i], 1);
                }
                newGuessB.append(guessChA[i]);
            }
        }
        
        String newGuess = newGuessB.toString();

        for (char ch : newGuess.toCharArray()) {
            if (map.containsKey(ch)) {
                int num = map.get(ch);
                if (num > 0) {
                    B++;
                    map.replace(ch, num, num - 1);
                }
            }
        }
        
        return String.valueOf(A) + "A" + String.valueOf(B) + "B";
    }
}