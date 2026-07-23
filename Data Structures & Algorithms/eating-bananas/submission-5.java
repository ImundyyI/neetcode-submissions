class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        // ^ this is the maximum k we can have.
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
            
        }

        // process each k at once, compile into an array of timeTakens, and search the array to find the 
        // closest timeTaken after that?

        // or, somehow narrow the search result.

        int l = 1;
        int r = max;
        int closestK = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (r + l) / 2;
            int median = calcTimeForK(piles, mid);

            // System.out.println("mid k: " + mid + " time taken: " + median + " l: " + l + " r: " + r);

            if (median > h) {
                l = mid + 1;
            } else {
                if (mid < closestK) {
                    // System.out.println("\tupdated:" + mid);
                    closestK = mid;
                }
                r = mid - 1;
            } 
        }

        return closestK;

       
    }

    public int calcTimeForK(int[] piles, int k) {
        int timeTaken = 0;
        for (int i = 0; i < piles.length; i++) {
            double pileTimeTaken = (double)piles[i] / k;
            timeTaken += Math.ceil(pileTimeTaken);
    
        }

        return timeTaken;

    }
}
