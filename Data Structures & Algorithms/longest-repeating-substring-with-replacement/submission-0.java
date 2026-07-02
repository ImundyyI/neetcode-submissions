class Solution {
    public int characterReplacement(String s, int k) {
        /*

        int lo = 0;
        int hi = 0;
        int maxFreq = 0;
        int max = 0;
        while (hi < length) then
            int freq = hm.put(s.charAt(hi), hm.getOrDefault(s.charAt(hi), 0) + 1);
            maxFreq = freq > maxFreq ? freq : maxFreq;

            int window = (hi - lo) + 1;
            while (window - maxFreq > k) {
                hm.put(s.charAt(lo), count.get(s.charAt(lo)) - 1);
                l++;
            }

            max = window > max ? window : max;


        end while
        */

        int lo = 0;
        int hi = 0;
        int maxFreq = 0;
        int max = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (hi < s.length()) {
            hm.put(s.charAt(hi), hm.getOrDefault(s.charAt(hi), 0) + 1);
            int freq = hm.get(s.charAt(hi));
            maxFreq = freq > maxFreq ? freq : maxFreq;

            // while there are w - f extra characters that must be replaced,
            // that cause the total amount of replacements to be above k,
            // increment the lo pointer.
            while ((hi - lo + 1) - maxFreq > k) {
                hm.put(s.charAt(lo), hm.get(s.charAt(lo)) - 1);
                lo++;

            }

            int window = (hi - lo + 1);

            max = window > max ? window : max;

            hi++;
        }

        return max;
        
    }
}
