class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0;
        int ans = nums.length + 1;
        for(int r=0;r<nums.length;r++) {
            sum += nums[r];
            while(sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        
        return ans == nums.length + 1 ? 0 : ans;
    }
}