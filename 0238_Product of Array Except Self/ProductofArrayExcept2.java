class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int l = 1, r = 1;
        for(int i=0;i<n;i++){
            ans[i] *= l;
            l *= nums[i];
            ans[n-i-1] *= r;
            r *= nums[n-i-1];
        }
        
        return ans;
    }
}