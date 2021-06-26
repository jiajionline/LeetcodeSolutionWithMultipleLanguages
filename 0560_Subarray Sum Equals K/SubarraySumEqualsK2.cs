public class Solution {
    public int SubarraySum(int[] nums, int k) {
        var ans = 0;
        var presum = new int[nums.Length+1];
        
        for(int i=0;i<nums.Length;i++){
            presum[i+1] = presum[i] + nums[i];
        }
        
        for(int start = 0;start < nums.Length; start++)
        {
            for(int end=start+1;end <= nums.Length;end++){
                if((presum[end] - presum[start]) == k) ans++;
            }
        }
        
        return ans;
    }
}