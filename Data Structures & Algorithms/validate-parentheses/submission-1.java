class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');
        for (char c : s.toCharArray()) {
            System.out.print("c: ");
            Character top = '\0';
            if (c == '(' || c == '{' || c == '[') {
                System.out.println("bracket open");
                stack.push(c);
                continue;
            }

            if (stack.peek() == null || hm.get(c) != stack.pop()) {
                return false;
            }

            // if (hm.get(c) != stack.pop()) {
            //     System.out.println("bracket close");
            //     return false;
                
            // }




        }

        if (stack.size() != 0) {
            return false;
        }

        return true;

        
    }
}
