class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return null;
        }

        

        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int lo = i + 1;
            int hi = len - 1;
            if (nums[i] > 0) {
                break;
            }

            // duplicate I values. just ignore it.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            

            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if (sum < 0) {
                    lo++;
                } else if (sum > 0) {
                    hi--;
                } else {
                    ls.add(List.of(nums[lo], nums[hi], nums[i]));
                    lo++;
                    hi--;

                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }

                    while (lo < hi && nums[hi + 1] == nums[hi]) {
                        hi--;
                    }
                }
            }

    
        }

        return ls;
        
    }
}
