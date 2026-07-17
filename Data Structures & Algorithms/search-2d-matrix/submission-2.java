class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int l = 0;
        int r = (height * width) - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            // cuts mantissa off so just rounds down.
            int row = mid / width; 
            int column = mid % width;
            int median = matrix[row][column];
            if (median == target) {
                return true;
            } else if (median > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return false;
        
    }
}
