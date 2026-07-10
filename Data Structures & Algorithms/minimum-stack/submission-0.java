class MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> mins = new ArrayDeque<>();

    // 3 1 2


    // stack: 3 1 2
    // mins:  3 1 1

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        int min = 0;
        if (mins.size() == 0 || (min = mins.peek()) > val) {
            mins.push(val);
            return;
        }

        mins.push(min);
        
    }
    
    public void pop() {
        stack.pop();
        mins.pop();
        
    }
    
    public int top() {
        return stack.peek();

        
        
    }
    
    public int getMin() {
        return mins.peek();
        
    }


}
