class Solution {
    public int[] productExceptSelf(int[] nums) {
        // f(i) = z / [i]
        // z = [1] . [2] . [3] ... [i]
        int fullProduct = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            } 

            fullProduct *= num;
            
        }

        // any product will be zero, so just return a zero-initialised array.
        if (zeroCount > 1) {
            return new int[nums.length];
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) {
                    nums[i] = fullProduct;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = fullProduct / nums[i];
            }

        }

        return nums;



        
        
    }
}  
