class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int cnt = 1;
        int ans = 1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                ans = Math.max(ans,++cnt);
            }else{
                cnt = 1;
            }
        }
        
        return ans;
    }
}