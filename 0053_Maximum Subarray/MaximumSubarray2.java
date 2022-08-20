class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        
        for(int v : nums){
            if(currMax < 0) {
                currMax = 0;
            }
            
            currMax += v;
            max = Math.max(max, currMax);
        }
        
        return max;
    }
}