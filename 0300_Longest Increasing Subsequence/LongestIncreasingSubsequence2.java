class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int[] f= new int[nums.length];
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans = Math.max(ans, LIS(nums, f, i));
        }

        return ans;
    }

    private int LIS(int[] nums, int[] f, int r){
        if(r == 0) return 1;
        if(f[r] > 0) return f[r];
        int ans = 1;
        for(int i=0; i<r;i++){
            if(nums[r] > nums[i]){
                ans = Math.max(ans, LIS(nums, f, i) + 1);
            }
        }

        f[r] = ans;
        return f[r];
    }
}