public class Solution {
    public int SubarraysWithKDistinct(int[] nums, int k) {
        return SubarraysWithMostKDistinct(nums, k) - SubarraysWithMostKDistinct(nums, k-1);
    }
    
    private int SubarraysWithMostKDistinct(int[] nums, int k)
    {
        var count = new int[nums.Length+1];
        var l = 0;
        var ans = 0;
        for(int r = 0;r < nums.Length;r++)
        {
            if(count[nums[r]]++ == 0) k--;
            
            while(k < 0)
            {
                if(--count[nums[l++]] == 0) k++;
            }
            
            ans += r - l + 1;
        }
        
        return ans;
    }
}