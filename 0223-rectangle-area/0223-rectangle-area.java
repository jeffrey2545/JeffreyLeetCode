class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 重疊邊
        int coveredX;
        int coveredY;
        if ((ax2 <= bx1 || bx2 <= ax1) || (ay2 <= by1 || by2 <= ay1)) {
            coveredX = 0;
            coveredY = 0;
        } else {
            coveredX = Math.abs(Math.max(ax1, bx1) - Math.min(ax2, bx2));
            coveredY = Math.abs(Math.max(ay1, by1) - Math.min(ay2, by2));
        }
        
        // 計算面積
        int aArea = (ax2 - ax1) * (ay2 - ay1);
        int bArea = (bx2 - bx1) * (by2 - by1);
        int covered = coveredX * coveredY;
        
        return aArea + bArea - covered;
    }
}
// -3, 3
// 0, 9
// 3

// 0, 4
// -1, 2
// 2
// (-5, 4), (0, 5)
// (-3, -3), (3, 3)