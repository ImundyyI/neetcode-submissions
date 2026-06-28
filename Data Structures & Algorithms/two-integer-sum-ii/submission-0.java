class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        if (length == 0) {
            return new int[0];
        }
        int lo = 0;
        int hi = length - 1;

        while (lo < hi) {
            int lVal = numbers[lo];
            int hVal = numbers[hi];
            int sum = lVal + hVal;

            // shorten window if sum of hi and lo pointers
            // are too small, we want a bigger number.
            if (sum < target) {
                lo++;

                // too big, decrease.
            } else if (sum > target) {
                hi--;
            } else {
                return new int[]{lo + 1, hi + 1};
            }



        }

        return new int[0];

      
        
        
    }
}
