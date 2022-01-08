public class Solution {
    public int Jump(int[] nums) {
        var furthest = 0;
        var currEnd = 0;
        var ans = 0;
        
        for(int i=0;i<nums.Length-1;i++)
        {
            furthest = Math.Max(furthest, nums[i] + i);
            if(currEnd == i)
            {
                ans++;
                currEnd = furthest;
            }
        }
        
        return ans;
    }
}