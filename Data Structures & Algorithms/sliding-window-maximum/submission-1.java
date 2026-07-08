class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(((a, b) -> b.val - a.val));
        int lo = 0;
        for (int i = 0; i < k - 1; i++) {
            pq.add(new Entry(i, nums[i]));
        }

        int[] arr = new int[nums.length - k + 1];
        int i = 0;
        for (int hi = k - 1; hi < nums.length; hi++) {
            while (pq.size() > 0 && pq.peek().index < lo) {
                pq.poll();
            }

            pq.add(new Entry(hi, nums[hi]));
            arr[lo] = pq.peek().val;



            lo++;   
        }

        return arr;

        
    }
}

public class Entry {
    public int index;
    public int val;
    public Entry(int index, int val) {
        this.index = index;
        this.val = val;
    }

}
