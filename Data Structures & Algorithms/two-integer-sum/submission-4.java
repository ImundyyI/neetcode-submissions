class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int l = nums.length;

        // we can use the fact that target = num[i] + num[j] for some i, j.
        // on the first pass, we know num[j] and target. we can hash each complement
        // target - num[j], giving num[i]. we can then do another pass to lookup num[i]
        // and see if the condition matches.
        for (int i = 0; i < l; i++) {
            int num = nums[i];
            hm.put(target - num, i);
        }
        

        // second pass to check the hashes.
        for (int i = 0; i < l; i++) {
            Integer value = null;
            int num = nums[i];
            if ((value = hm.get(num)) != null && value != i) {
                return new int[]{i, value};
            }

        }

        return null;   
    }
}
