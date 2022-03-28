class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length <=2 ) return false;
        int max = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int v : nums) {
            if(v <= min) {
                min = v;
            }else if(v <= max) {
                max = v;
            }else 
                return true;
        }
        
        return false;
    }
}