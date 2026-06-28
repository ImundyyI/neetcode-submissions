class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String str : strs) {

            // convert to char array and sort.
            char[] arrc = str.toCharArray();
            Arrays.sort(arrc);
            String sorted = new String(arrc);
            
            // check if it is contained in HM. if it isnt, generate a new List
            // generic and add it. otherwise just add it to the existing entry.
            ArrayList<String> earr = null;
            if ((earr = hm.get(sorted)) != null) {
                earr.add(str);
            } else {
                hm.put(sorted, new ArrayList<>(List.of(str)));

            }


        }
        

        return new ArrayList<>(hm.values());
        
    }
}
