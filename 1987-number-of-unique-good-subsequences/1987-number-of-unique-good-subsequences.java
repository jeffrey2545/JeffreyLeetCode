class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int mod = (int) 1e9 + 7, endsWithZero = 0, endsWithOne = 0, hasZero = 0;

        for (int i = 0; i < binary.length(); ++i) {
            if (binary.charAt(i) == '1') {
                endsWithOne = (endsWithZero + endsWithOne + 1) % mod;
            } else {
                endsWithZero = (endsWithZero + endsWithOne) % mod;
                hasZero = 1;
            }
        }
        return (endsWithZero + endsWithOne + hasZero) % mod;
    }
}