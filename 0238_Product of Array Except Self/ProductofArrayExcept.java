class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int accu = 1;
        for(int i=0;i<n;i++){
            ans[i] *= accu;
            accu *= nums[i];
        }
        
        accu = 1;
        for(int i=n-1;i>=0;i--) {
            ans[i] *= accu;
            accu *= nums[i];
        }
        
        return ans;
    }
}