public class Codec {
    List<Integer> startIndex;

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        startIndex = new ArrayList<>();
        String ans = "";
        int index = 0;
        for (String str : strs) {
            ans = ans + str;
            index = index + str.length();
            startIndex.add(index);
        }
        return ans;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        for (int index : startIndex) {
            String string = s.substring(start, index);
            ans.add(string);
            start = index;
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));