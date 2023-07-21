class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = nums.length + 1;
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(validate(nums, target, mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l == nums.length + 1 ? 0 : l;
    }

    private boolean validate(int[] nums, int target, int size) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++) {
            sum += nums[i];
            if(i-size >= 0) sum -= nums[i-size];
            if(sum >= target) return true;
        }
        return false;
    }
}