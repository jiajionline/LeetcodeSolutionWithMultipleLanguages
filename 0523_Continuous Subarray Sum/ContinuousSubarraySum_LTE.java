class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null  || nums.length <= 1) return false;
        int n = nums.length;
        int[] presum = new int[n];
        presum[0] = nums[0];
        for(int i=1;i<n;i++) presum[i] = presum[i-1] + nums[i];

        for(int len=2;len<=n;len++) {
            for(int l = 0;l+len<=n;l++) {
                int r = l + len - 1;
                int v = l == 0 ? presum[r] : presum[r] - presum[l-1];
                if(v % k == 0) return true;
            }
        } 
        return false;
    }
}