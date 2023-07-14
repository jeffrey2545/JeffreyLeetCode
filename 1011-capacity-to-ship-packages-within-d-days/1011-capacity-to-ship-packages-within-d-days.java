class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE, max = 0;
        for (int weight : weights) {
            max = max + weight;
            min = Math.max(min, weight);
        }
        
        while (min < max) {
            int mid = min + (max - min) / 2;
            int time = help(weights, mid);
            if (time <= days) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    
    private int help(int[] weights, int capacity) {
        int daysNeeded = 1, currentLoad = 0;
        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > capacity) {
                daysNeeded++;
                currentLoad = weight;
            }
        }
        return daysNeeded;
    }
}