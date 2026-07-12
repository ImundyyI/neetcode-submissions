class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i;
            while (j < temperatures.length && temperatures[j] <= temperatures[i]) {
                j++;
            }

            result[i] = j >= temperatures.length ? 0 : (j - i);
        }


        return result;
        
    }
}
