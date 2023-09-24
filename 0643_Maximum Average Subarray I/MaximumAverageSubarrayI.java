class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        double ans = -Double.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(i + 1 >= k) {
                ans = Math.max(ans, sum / k);
                sum -= nums[i+1-k];
            }
        }
        return ans;
    }
}