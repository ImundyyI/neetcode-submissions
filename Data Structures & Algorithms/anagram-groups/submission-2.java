class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            System.out.println("\n");
            // process all characters in each string, add to key.
            Key k = new Key();
            char[] chararray = str.toCharArray();
            for (char c : chararray) {
                System.out.println(c);
                k.ins(c);
            }

            String key = Arrays.toString(k.freq);

            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(str);

        }    

        return new ArrayList<>(hm.values());    
        
    }
}

// maintain key to map each character.
class Key {
    public int[] freq;
    public Key() {
        freq = new int[26];

    }

    // minimum of ASCII 'a' otherwise it will break.
    public void ins(char c) {
        freq[c - 'a']++;
    }
}
