public class Solution {
    public int LongestSubarray(int[] nums) {
        int ans = 0;
        int sum = 0;
        for(int l=0, r=0 ; r<nums.Length;r++){
            sum += nums[r];
            while(l<r && sum < r-l)
                sum-=nums[l++];
            ans = Math.Max(ans, r-l);
        }
        return ans;
    }
}