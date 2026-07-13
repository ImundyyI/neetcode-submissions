class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] timeReached = new double[position.length];

        // find the time taken for each car to reach the target.
        for (int i = 0; i < position.length; i++) {
            timeReached[i] = (double)(target - position[i]) / (double)speed[i];
            // System.out.println(timeReached[i]);
        }

        Integer[] indices = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> position[i]));

        Deque<Double> dq = new ArrayDeque<>();
        
        for (int i = 0; i < position.length; i++) {
            double t = timeReached[indices[i]];
            while (dq.size() > 0 && dq.peek() <= t) {
                dq.pop();
            }
            dq.push(t);
        }

        return dq.size();
        
    }


}
