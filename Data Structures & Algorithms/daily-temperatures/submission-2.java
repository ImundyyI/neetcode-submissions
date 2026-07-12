class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            while (dq.size() != 0 && temperatures[dq.peek()] < temperatures[i]) {
                int index = dq.pop();
                result[index] = i - index;
            }

            dq.push(i);
        }

        // we hit the end of the array. anything left on the stack has no higher temperature left,
        // so we just set the elements under these enumerated indexes to 0.

        while (dq.size() > 0) {
            int index = dq.pop();
            result[index] = 0;
        }

        return result;
        
    }
}
