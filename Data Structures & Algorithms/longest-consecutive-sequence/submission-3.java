class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }

        int i = 0;
        int maxLen = 1;
        while (i < nums.length) {
            int num = nums[i];
            if (visited.contains(num)) {
                i++;
                continue;
            }

            // starting point.
            if (!hs.contains(num - 1)) {
                int len = 1;
                visited.add(num);
                while (hs.contains(num + len)) {
                    visited.add(num + len);
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
 