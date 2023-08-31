class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        for(int len=1;len<=nums.length;len++) {
            for(int l=0;l+len<=nums.length;l++) {
                int r = l + len - 1;
                int sum = 0;
                for(int k=l;k<=r;k++) {
                    sum += nums[k];
                }
                if(sum == goal) ans++;
            }
        }
        
        return ans;
    }
}