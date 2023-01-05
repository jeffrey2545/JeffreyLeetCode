class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> first = new ArrayList<>();
        first.add(1);
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(first);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> curr = result.get(result.size() - 1);
            List<Integer> newRow = row(curr);
            result.add(newRow);
        }
        return result;
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