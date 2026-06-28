class Solution {
    public int trap(int[] height) { 
        int len = height.length;
        int l = 0;
        int r = len - 1;
        int area = 0;
        int maxLeftHeight = height[l];
        int maxRightHeight = height[r];
        int lA = 0;
        int rA = 0;
        // increment l, r pointer. these should converge on eachother.
        while (l < r) {
            int lHeight = height[l];
            int rHeight = height[r];
            
            if (lHeight <= rHeight) {
                // we have found a bound for the container, so update max/       
                l++;
                if (height[l] >= maxLeftHeight) {
                    area += lA;
                    lA = 0;
                    maxLeftHeight = height[l];
                } else {
                    lA += maxLeftHeight - height[l];
                }

                
                
            } else {
                r--;
                if (height[r] >= maxRightHeight) {
                    area += rA;
                    rA = 0;
                    maxRightHeight = height[r];
                } else {
                    rA += maxRightHeight - height[r];
                }
            }


        }

        return area;

        
    }
}
