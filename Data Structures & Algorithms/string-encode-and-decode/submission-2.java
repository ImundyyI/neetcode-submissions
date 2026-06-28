class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            for (char c : chars) {
                builder.append(c).append('0');
            }
            // append delimiter.
            builder.append("01");

        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        char[] chars = str.toCharArray();

        StringBuilder debuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i += 2) {
             // delimiter.
            if (chars[i + 1] == '1') {
                strs.add(debuilder.toString());
                debuilder.setLength(0);
            } else {
                debuilder.append(chars[i]);

            }
            
           
            
        }

        return strs;


    }
}
