class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        
        while (min < max) {
            int mid = min + (max - min) / 2;
            int time = operation(piles, mid);
            if (time > h) {
                min = mid + 1;
            } else if (time <= h) {
                max = mid;
            }
        }
        return min;
    }
    
    private int operation(int[] piles, int k) {
        int sum = 0;
        for (int pile : piles) {
            if (pile <= k) {
                sum++;
            } else {
                sum = sum + (pile / k);
                if (pile % k > 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}