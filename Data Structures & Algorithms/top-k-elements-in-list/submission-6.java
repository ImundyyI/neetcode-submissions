class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = nums.length + 1;
        List<Integer>[] freqs = new List[len];
        for (int i = 0; i < len; i++) {
            freqs[i] = new ArrayList<>();
        }
        // generate hash table.
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        if (hm.size() == 0) {
            return new int[]{};
        }

        AtomicInteger max = new AtomicInteger(0);
        // generate seperate chained reverse index hash-table.
        hm.entrySet().stream().forEach(entry -> {
            int freq = entry.getValue();
            freqs[freq].add(entry.getKey());
            if (freq > max.get()) {
                max.set(freq);
            }
        });

        int count = 0;
        int[] topK = new int[k];
        for (int i = max.get(); i > 0 && count < k; i--) {
            for (int val : freqs[i]) {
                topK[count] = val;
                if (++count == k) {
                    return topK;
                }

            }
 


        }

        return topK;
    }
}
