class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int[] memo= new int[nums.length];
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans = Math.max(ans, LIS(nums, memo, i));
        }

        return ans;
    }

    private int LIS(int[] nums, int[] memo, int r){
        if(r == 0) return 1;
        if(memo[r] > 0) return memo[r];
        int ans = 1;
        for(int i=0; i<r;i++){
            if(nums[r] > nums[i]){
                ans = Math.max(ans, LIS(nums, f, i) + 1);
            }
        }

        memo[r] = ans;
        return ans;
    }
}