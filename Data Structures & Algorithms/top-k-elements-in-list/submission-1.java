class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] topK = new int[k];
        HashMap<Integer, Integer> hm = new HashMap<>();

        // descending order based on freq (value) order.
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) 
                                                        -> a.getValue() - b.getValue());
        // hash num frequency.
        for (int num : nums) {
            int val = 0;
            val = hm.getOrDefault(num, 0);
            hm.put(num, val + 1);
        }
        // heapify key-value pairs based on descending order.
        Set<Map.Entry<Integer, Integer>> vset = hm.entrySet();
        vset.stream().forEach(entry -> {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        });

        // deheapify for the first k entries.
        int count = 0;
        while (count < k) {
            Map.Entry<Integer, Integer> entry = null;
            if ((entry = pq.poll()) == null) {
                break;
            }

            int val = entry.getKey();
            topK[count] = val;
            count++;

        }



        return topK;
        
    }
}

