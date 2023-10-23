class Solution {
    public int[][] merge(int[][] intervals) {
        // sort
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // iterate
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = ans.get(ans.size() - 1);
            int[] curr = intervals[i];
            if (prev[1] >= curr[0]) {
                int[] merge = new int[]{prev[0], Math.max(prev[1], curr[1])};
                ans.remove(ans.size() - 1);
                ans.add(merge);
            } else {
                ans.add(curr);
            }
        }
        // convert list to array
        int[][] ansArr = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
}
// [1,3][2,6][3,5][8,10][15,18]
// prev = [1,6]
// curr = [3,5]
// merge = [prev.start, max(prev.end, curr.end)]

