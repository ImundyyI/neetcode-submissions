class Solution {
    public String minWindow(String s, String t) {
        // K X Y Z
        // V f f t

        /*
            O U Z O D Y X A Z V
            . . .
        */
        HashMap<Character, Value> hm = new HashMap<>();
        for (char c : t.toCharArray()) {
            Value v = hm.getOrDefault(c, new Value(0, 0));
            v.freq++;
            hm.put(c, v);
        }
        

        int maxLo = 0;
        int maxHi = 0;
        int maxLength = Integer.MAX_VALUE;
        int lo = 0;
        int count = 0;
        for (int hi = 0; hi < s.length(); hi++) {
            Value v = null;
            if ((v = hm.get(s.charAt(hi))) != null) {
                v.count++;
                if (v.count == v.freq) {
                    count += v.freq;
                }

            }

            while (count == t.length() && lo <= hi) { 
                if ((v = hm.get(s.charAt(lo))) != null) {
                    v.count--;
                    if (v.count < v.freq) {
                        count -= v.freq;
                    }
                }

                if (hi - lo + 1 < maxLength) {
                    maxLength = hi - lo + 1;
                    maxLo = lo;
                    maxHi = hi;
                }

                lo++;
            }


        }

        if (maxLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(maxLo, maxHi + 1);
        
    }
}

public class Value {
    public int freq;
    public int count;


    public Value(int freq, int count) {
        this.freq = freq;
        this.count = count;
    }
}
