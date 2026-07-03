class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Entry> hm = new HashMap<>();

        // store frequency of each character.
        char[] arr = s1.toCharArray();
        for (char c : arr) {
            Entry e = null;
            e = hm.getOrDefault(c, new Entry());
            e.freq++;
            hm.put(c, e);

        }
        
        int tally = 0;
        int lo = 0;
        for (int hi = 0; hi < s2.length(); hi++) {
            // mapping exists.
            Entry he = null;
            if ((he = hm.get(s2.charAt(hi))) != null) {
                
                he.count++;
                if (he.count == he.freq) {
                    
                    tally += he.freq;
                }
            }

            int s1length = s1.length();
            if (tally == s1length) {
                return true;

            }

            if (hi < s1length - 1) {
                continue;
            }

            
            
            Entry le = null;
            if ((le = hm.get(s2.charAt(lo))) != null) {
                if (le.count == le.freq) {
                    tally -= le.freq;

                }

                le.count--;
            }
            lo++;
        }

        return false;
        


        
    }

    public class Entry {
        public int freq = 0;
        public int count = 0;

    }
}
