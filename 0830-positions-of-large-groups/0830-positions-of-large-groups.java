class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char[] sArr = s.toCharArray();
        char tmp = sArr[0];
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (sArr[i] == tmp) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i - count);
                    list.add(i - 1);
                    result.add(list);
                    
                    tmp = sArr[i];
                    count = 1;
                } else {
                    tmp = sArr[i];
                    count = 1;
                }
            }
        }
        if (count >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(sArr.length - count);
            list.add(sArr.length - 1);
            result.add(list);
        }
        return result;
    }
}