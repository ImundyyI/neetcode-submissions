class Solution {
    public int maxArea(int[] heights) {
        int lo = 0;
        int hi = heights.length - 1;
        int max = 0;
        while (lo < hi) {
            int lH = heights[lo];
            int hH = heights[hi];
            int area = min(lH, hH) * (hi - lo);
            if (area > max) {
                max = area;
            }

            if (lH < hH) {
                lo++;
            } else {
                hi--;
            }


        }

        return max;
        
    }

    public static int min(int a, int b) {
        return a > b ? b : a;
    }
}
