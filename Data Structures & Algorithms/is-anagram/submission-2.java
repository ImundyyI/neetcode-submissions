class Entry {
    public int sc;
    public int tc;

    public Entry(int sc, int tc) {
        this.sc = sc;
        this.tc = tc;
    }
}


class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Entry> hm = new HashMap<>();

        if (s == null || t == null) return false;

        // wonmt have an anagram if differing sizes.
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }


        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            Entry e = null;
            if ((e = hm.get(c)) == null) {
                hm.put(c, new Entry(1, 0));
            } else {
                e.sc++;
            }
            
        }

        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            Entry e = null;
            if ((e = hm.get(c)) == null) {
                return false;
            } else {
                if (e.tc++ > e.sc) {
                    return false;
                }
            }
            
        }

        return !(hm.values().stream().filter(x -> x.tc != x.sc).count() > 0);

    }
}
