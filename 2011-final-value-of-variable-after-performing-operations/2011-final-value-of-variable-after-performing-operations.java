class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        
        for (String ope : operations) {
            if (ope.indexOf("+") >= 0) {
                x++;
            } else {
                x--;
            }
        }
        
        return x;
    }
}