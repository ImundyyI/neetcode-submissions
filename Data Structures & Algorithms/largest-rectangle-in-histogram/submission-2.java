class Solution {
    public int largestRectangleArea(int[] heights) {
         // for each bar.
        int maxArea = 0;
        Deque<Entry> s = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            Entry entry = null;
            // we have hit a value toward the right of prior bars that would cuase
            // their areas to be cut off. check the total area they could obtain.
            while (s.size() != 0 && ((entry = s.peek()).h) > heights[i]) {
                s.pop();
                int area = (i - entry.i) * entry.h;
                if (area > maxArea) {
                    maxArea = area;
                }

                // get the earliest possible index that its area could start at.
                start = entry.i;


            }

            s.push(new Entry(heights[i], start));
        }

        while (s.peek() != null) {
            Entry entry = s.pop();
            int area = (heights.length - entry.i) * entry.h;
            if (area > maxArea) {
                maxArea = area;
            }
        }


        return maxArea;
        
    }

    public class Entry {
        public int h;
        public int i;
        public Entry(int h, int i) {
            this.h = h;
            this.i = i;
        }


    }
}
