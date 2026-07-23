class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            // we know it is out of order. expand search upward.
            int mid = (r + l) / 2;
            int val = nums[mid];

            System.out.println("m: " + mid  +" l: " + l + " r:" + r);
            // we have found a descending value. this means that anything to the right
            // of val will not be the index at which it is rotated, so ignore it.
            if (nums[l] < val) {
                if (nums[l] < nums[r]) {
                    r = mid;
                } else {
                    l = mid;
                } 
            // out of order. we have found something that is not in order. its up to us to out
            // what side of this out of order value to search.  
            } else if (nums[l] > val) {
                r = mid;
            } else {
                if (nums[l] < nums[r]) {
                    r--;
                } else {
                    l++;
                }
            }

            

        }


        return nums[l];
        
    }
}
