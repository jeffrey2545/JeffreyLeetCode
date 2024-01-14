class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                list.add(c);
            }
        }
        
        int i = list.size() - 1;
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                ans.append(list.get(i));
                i--;
            } else {
                ans.append(c);
            }
        }
        
        return ans.toString();
    }
}