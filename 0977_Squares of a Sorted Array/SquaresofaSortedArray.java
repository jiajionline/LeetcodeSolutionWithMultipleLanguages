class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        int l = 0, r = n-1; 
        for(int i=n-1;i>=0;i--)
        {
            if(nums[l] * nums[l] >= nums[r] * nums[r]) {
                ans[i] = nums[l] * nums[l];
                l++;
            }else {
                ans[i] = nums[r] * nums[r];
                r--;
            }
        }
        
        return ans;
    }
}