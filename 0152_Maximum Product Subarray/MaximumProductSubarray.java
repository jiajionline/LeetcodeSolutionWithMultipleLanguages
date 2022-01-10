class Solution {
    public int maxProduct(int[] nums) {
        int prevMax = nums[0];
        int prevMin = nums[0];
        int ans = nums[0];
        
        for(int i=1;i<nums.length;i++) {
            int currMax = Math.max(prevMax * nums[i], prevMin * nums[i]);
            currMax = Math.max(nums[i], currMax);
            
            int currMin = Math.min(prevMax * nums[i], prevMin * nums[i]);
            currMin = Math.min(nums[i], currMin);
            
            ans = Math.max(ans, currMax);
            prevMax = currMax;
            prevMin = currMin;
        }
        
        return ans;
    }
}