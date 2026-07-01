class Solution {
    public int maxProfit(int[] prices) {
        int lo = 0;
        int hi = 1;
        int max = 0;
        while (hi < prices.length) {
            int profit = prices[hi] - prices[lo];
            if (profit > 0) {
                max = profit > max ? profit : max;
                
            } else {
                lo = hi;
            }

            hi++;
        }

        return max;


        
    }
}
