class Solution {

    public String encode(List<String> strs) {
        String builder = "";
        for (String str : strs) {
            char[] chars = str.toCharArray();
            for (char c : chars) {
                builder += c + "0";
            }
            // append delimiter.
            builder += "01";

        }

        return builder;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        char[] chars = str.toCharArray();

        String debuilder = "";
        for (int i = 0; i < chars.length; i += 2) {
             // delimiter.
            if (chars[i + 1] == '1') {
                strs.add(debuilder);
                debuilder = "";
            } else {
                debuilder += chars[i];

            }
            
           
            
        }

        return strs;


    }
}
