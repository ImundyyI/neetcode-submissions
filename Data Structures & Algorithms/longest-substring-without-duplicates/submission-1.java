class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int lo = 0;
        int hi = 0;
        int max = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (hi < s.length()) {
            if (hm.containsKey(s.charAt(hi))) {
                lo = Math.max(hm.get(s.charAt(hi)) + 1, lo);

            }

            hm.put(s.charAt(hi), hi);
            max = Math.max(max, hi - lo + 1);
            hi++;

        }

        return max;


        
    }
}
