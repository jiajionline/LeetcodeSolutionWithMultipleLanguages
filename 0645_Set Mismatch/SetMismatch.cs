public class Solution {
    public int[] FindErrorNums(int[] nums) {
        var ans = new int[2];
        
        for(var i=0;i<nums.Length;i++) 
        {
            var index = Math.Abs(nums[i])-1; 
            if(nums[index] < 0)
                ans[0] = index + 1;
            else 
            {
               nums[index] = 0 - nums[index]; 
            }
        }
        
        for(int i=0;i<nums.Length;i++)
            if(nums[i] > 0)
                ans[1] = i+1;
        
        return ans;
    }
}