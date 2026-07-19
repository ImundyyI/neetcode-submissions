class Solution {
    public int largestRectangleArea(int[] heights) {
        // for each bar.
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && heights[l] >= heights[i]) {
                l--;
            }

            l++;

            while (r < heights.length && heights[r] >= heights[i]) {
                r++;
            
            }

            r--;

            int area = ((r - l) + 1) * heights[i];
            if (area > maxArea) {
                maxArea = area;
            }

        }
        return maxArea;
    }
}
