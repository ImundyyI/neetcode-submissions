class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num =  nums[i];
            if (num > 0) {
                break;
            }

            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                // we need distinct indexes, so continue.
                int sum = nums[lo] + nums[hi] + num;


                // check that they sum to zero.
                
                if (sum < 0) {
                    lo++;
                } else if (sum > 0) {
                    hi--;

                } else {
                    // add to list, and record what indexes we have used.
                    ls.add(List.of(nums[lo], nums[hi], num));
                    hi--;
                    lo++;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                }
            }

        }

        return ls;

        
    }
}
