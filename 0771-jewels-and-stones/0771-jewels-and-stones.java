class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            set.add(jewel);
        }
        
        int ans = 0;
        for (char stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                ans++;
            }
        }
        
        return ans;
    }
}