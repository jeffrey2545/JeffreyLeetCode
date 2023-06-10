class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int count = 0;
        while (left < right) {
            int leftWeight = people[left];
            int rightWeight = people[right];
            if (leftWeight + rightWeight <= limit) {
                right--;
                left++;
            } else {
                right--;
            }
            count++;
        }
        if (left == right) {
            count++;
        }
        return count;
    }
}