class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> first = new ArrayList<>();
        first.add(1);
        if (rowIndex == 0) {
            return first;
        }
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        if (rowIndex == 1) {
            return second;
        }
        for (int i = 0; i < rowIndex - 1; i++) {
            second = row(second);
        }
        return second;
    }
    
    public List<Integer> row(List<Integer> pre) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < pre.size() - 1; i++) {
            int num = pre.get(i) + pre.get(i + 1);
            result.add(num);
        }
        result.add(1);
        return result;
    }
}