class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int ans = 0;
        long sum = 0;
        
        for(int r = 0;r<nums.length;r++) {
            sum += nums[r];
            while(l < r && ((sum + k) < nums[r] * (r - l+1)))
                sum -= nums[l++];    
            ans = Math.max(ans, r - l + 1);
        }
        
        return ans;
    }
}