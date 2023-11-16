class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        int loop = 2 * numRows - 2;
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, new ArrayList<>());
        }
        
        int index = 0;
        boolean flip = false;
        for (char c : s.toCharArray()) {
            List<Character> list = map.get(index);
            list.add(c);
            map.put(index, list);
            
            if (index == numRows - 1) {
                flip = true;
            }
            if (index == 1 && flip) {
                flip = false;
                index = -1;
            }
            
            if (flip) {
                index--;
            } else {
                index++;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            List<Character> list = map.get(i);
            for (char c : list) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
// 2 * numRows - 2 = set
// left
// left + 1, right
// left + 2, right - 1
// left + 3, right - 2
    
// PAYPAL
// 0 = P I N
// 1 = A L S I G
