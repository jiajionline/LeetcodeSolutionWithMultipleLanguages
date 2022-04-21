class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubArray(nums, k) - countSubArray(nums, k - 1);
    }
    
    public int countSubArray(int[] nums, int k){
        
        int ans = 0;
        int diff = 0;
        int l = 0;
        int[] count = new int[nums.length+1];
        for(int r = 0; r < nums.length; r++){
            
            if((count[nums[r]]) == 0) diff++;
            count[nums[r]]++;
            
            while(diff > k){
                count[nums[l]]--;
                if(count[nums[l]] == 0) diff--;
                l++;
            }
            
            ans += r - l + 1;
        }
            return ans;
    }

}