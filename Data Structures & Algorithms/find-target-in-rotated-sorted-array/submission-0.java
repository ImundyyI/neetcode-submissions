class Solution {
    public int search(int[] nums, int target) {
        int min = getMinIndex(nums);
        int r = nums.length - 1;
        int l = 0;
        if (nums[r] < target) {
            r = min;
        } else {
            l = min;
        }

        // we have now found the segment we wish to search in,
        // just run BS like normal.
        while (l <= r) {
            int mid = (l + r) / 2;
            int median = nums[mid];
            if (median > target) {
                r = mid - 1;
            } else if (median < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;



        
    }

    public int getMinIndex(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int mv = nums[mid];
            if (nums[l] < mv) {
                // case where we are in a normal segment. should check the leftmost
                // since the minimum will be to the left.
                if (nums[l] < nums[r]) {
                    r = mid;
                // disjoint. if the right-most is less than the left-most, clearly 
                // the minimum will actuaally be to the right, so we set hte lower bound 
                // to the middle value we just checked.
                } else {
                    l = mid;
                }
        
            } else if (nums[l] > mv) {
                r = mid;

            // edge case where l and r are adjacent but not equal.
            } else {
                if (nums[l] > nums[r]) {
                    l++;
                } else {
                    r--;
                }
                
            }
        }

        return l;
    }
}
