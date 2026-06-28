class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        for (int num : nums) {
            if (map.putIfAbsent(num, true) != null) {
                return true;
            }
        }

        return false;

        
    }
}