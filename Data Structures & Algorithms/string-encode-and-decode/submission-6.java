class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        strs.stream().forEach(str -> builder.append(str.length()).append('/').append(str));
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            // found the delimiter.
            char c;
            int count = 0;
            while ((c = str.charAt(j)) != '/') {
                count *= 10;
                count += c - '0';
                j++;
            }
        
            // int count = Integer.parseInt(str.substring(i, j));

            i = j + 1;
            j = i + count;
            list.add(str.substring(i, j));
            i = j;




        }

        return list;

    }
}
