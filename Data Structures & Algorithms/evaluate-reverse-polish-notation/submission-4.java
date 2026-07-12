class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0;
        while (i < tokens.length) {
            String s = tokens[i];
            char c = s.length() == 1 ? s.charAt(0) : 'a';
            
            if (c == '+' || c == '-' || c == '/' || c == '*') {
                System.out.println(c);
                // squash stack into one-value via specified operand.
                int b = dq.pop();
                int a = dq.pop();
                int res = compute(a, b, c);
                dq.push(res);
                System.out.println("a: " + a + " b: " + b + " result: " + dq.peek());
            } else {
                int p = Integer.parseInt(s);
                System.out.println("pushing:" + p);
                dq.push(p);
            }
    
            i++;
        }

        return dq.pop();
        
    }

    public int compute(int a, int b, char op) {
        switch (op) {
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '-':
                return a - b;
            default:
                return a + b;
        }
    }

}
