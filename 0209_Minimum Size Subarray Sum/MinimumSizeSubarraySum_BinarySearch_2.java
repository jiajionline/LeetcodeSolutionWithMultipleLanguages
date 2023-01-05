class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 1, r = nums.length, ans = nums.length + 1;
        while(l <= r) {
            int mid = (r-l)/2 + l;
            if(validate(nums, target, mid)){
                ans = Math.min(ans, mid);
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return ans == nums.length + 1 ? 0 : ans;
    }
    
    private boolean validate(int[] nums, int target, int size) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(i - size >= 0) sum -= nums[i-size];
            if(sum >= target) return true;
        }
        
        return false;
    }
}