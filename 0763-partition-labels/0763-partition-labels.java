class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            char word = sArr[i];
            if (map.containsKey(word)) {
                map.replace(word, map.get(word), i);
            } else {
                map.put(word, i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < sArr.length; i++) {
            int end = map.get(sArr[i]);
            //System.out.println(sArr[i]);
            //System.out.println(end);
            for (int start = i; start < end; start++) {
                char word = sArr[start];
                int index = map.get(word);
                if (index > end) {
                    end = index;
                    //System.out.println(word);
                    //System.out.println(end);
                }
            }
            result.add(end - i + 1);
            i = end;
        }
        return result;
    }
}