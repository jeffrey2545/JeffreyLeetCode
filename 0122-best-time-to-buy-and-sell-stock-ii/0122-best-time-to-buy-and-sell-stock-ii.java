class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int noHold = 0;
        
        for (int price : prices) {
            int prehold = hold;
            int preNoHold = noHold;
            
            hold = Math.max(prehold, preNoHold - price);
            noHold = Math.max(preNoHold, prehold + price);
        }
        
        return noHold;
    }
}