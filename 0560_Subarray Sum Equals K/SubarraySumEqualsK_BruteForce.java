class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for(int l=0;l<nums.length;l++) {
            int count = 0;
            int sum = 0;
            for(int r = l;r<nums.length;r++) {
                sum += nums[r];
                if(sum == k) count++;
            }
            ans += count;
        }
        return ans;
    }
}