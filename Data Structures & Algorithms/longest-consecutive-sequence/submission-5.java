class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }

        int i = 0;
        int maxLen = 1;
        while (i < nums.length) {
            int num = nums[i];


            // starting point.
            if (!hs.contains(num - 1)) {
                int len = 1;
                while (hs.contains(num + len)) {
                    len++;

                }

                if (len > maxLen) {
                    maxLen = len;
                }
            }
            i++;
        }

        return maxLen;
    }
}
 