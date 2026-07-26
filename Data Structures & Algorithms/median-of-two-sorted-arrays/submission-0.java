class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        //     0 1 2 3 4 
        //   -  - - - - - - - - 
        // a = 1 7 8
        //         [  
        // b = 2 6 10 11 12 
                   [
        // a = 1 3 6
        //       ]  
        // b = 2 7 8 
               ]

        */

        // swap it to ensure that nums1 always has the lower amount.
        if (nums2.length < nums1.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        // 1 2 3 6] 7 8 9
        // 1 2 3 6] [7 8 9 10
        int total = nums1.length + nums2.length;
        int half = total / 2;
        int mid1 = nums1.length / 2;
        int mid2 = half - mid1;

        while (get(nums2, mid2 - 1) > get(nums1, mid1) || get(nums1, mid1 - 1) > get(nums2, mid2)) {
            mid1++;
            mid2--;
        }

        // System.out.println("m1: " + mid1 + " m2: " + mid2);
        if (total % 2 == 1) {
            return Math.min(get(nums2, mid2), get(nums1, mid1));
        } else {
            return (Math.min(get(nums2, mid2), get(nums1, mid1)) + 
            Math.max(get(nums2, mid2 - 1), get(nums1, mid1 - 1))) / 2f;
        }

        
        // return 0;


        // parittion it. if the sum of length is odd, we must take the max element in the bottom half.
        // otherwise, average the max element i the bottom half, and the minimum element in the top half.


        

    }

    public int get(int[] arr, int index) {
        if (index < 0) {
            return Integer.MIN_VALUE;
        } else if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }

        return arr[index];
    }
}
