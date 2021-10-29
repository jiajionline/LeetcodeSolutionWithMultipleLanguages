public class Solution {
    public int MinSubArrayLen(int target, int[] nums) {
        var ans = nums.Length + 1;
        
        var begin = 0;
        var end = 0;
        
        var sum = 0;
        while(end < nums.Length)
        {           
           sum += nums[end++];
         
          while (sum >= target) {
               ans = Math.Min(ans, end - begin);
               sum -= nums[begin++];
           } 

        }
        return ans == nums.Length +1 ? 0 : ans;
    }
}