class Solution {
    public boolean isPalindrome(String s) {
        // dont check the middle case because it doesnt matter.
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            char loC = Character.toUpperCase(s.charAt(lo));
            if (!(Character.isLetter(loC) || Character.isDigit(loC))) {
                lo++;
                continue;
            }
            char hiC = Character.toUpperCase(s.charAt(hi));
            if (!(Character.isLetter(hiC) || Character.isDigit(hiC))) {
                hi--;
                continue;
            }

            System.out.println("lo: " + loC + "hi: " + hiC);
            if (loC != hiC) {
                return false;
            }

            lo++;
            hi--;


        }

        return true;
        
    }
}
