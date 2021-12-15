public class Solution {
    public bool CanJump(int[] nums) {
        var furthest = 0;
        for(int i=0;i<nums.Length;i++)
        {
            if(furthest >= i)
            {
                furthest = Math.Max(furthest, nums[i] + i);
                if(furthest >= (nums.Length-1)) break;
            }
            else 
                break;
        }
        
        return furthest >= nums.Length - 1;
    }
}