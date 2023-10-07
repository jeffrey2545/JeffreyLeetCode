class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean first = false;
        boolean second = false;
        boolean third = false;
        for (int[] triple : triplets) {
            if (triple[0] > target[0] || triple[1] > target[1] || triple[2] > target[2]) {
                continue;
            }
            if (triple[0] == target[0]) {
                first = true;
            }
            if (triple[1] == target[1]) {
                second = true;
            }
            if (triple[2] == target[2]) {
                third = true;
            }
        }
        return first && second && third;
    }
}