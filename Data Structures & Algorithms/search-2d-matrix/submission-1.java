class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length; // column-wise.
        int depth = matrix.length; // row-wise.
        int upper = 0;
        int lower = depth - 1;
        
        // find the row at which the value might be in based on the left (minimum val)
        // and right (maximum val) for that row.
        while (upper <= lower) {
            int mid = (upper + lower) / 2;
            int l = matrix[mid][0];
            int r = matrix[mid][width - 1];
            if (l == target) {
                return true;
            }

            if (r == target) {
                return true;
            }
            
            if (target < l) {
                lower = mid - 1;
                
            } else if (target > r) {
                upper = mid + 1;
            } else {
                return bsearch(matrix[mid], 0, width - 1, target);
            }


        }
        // return false;
        // mid should be width-based
        return false;
        
    }

    public static boolean bsearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = (r + l) / 2;
            int median = arr[mid];
            if (median == target) {
                return true;
            } else if (median < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;

    }
}
