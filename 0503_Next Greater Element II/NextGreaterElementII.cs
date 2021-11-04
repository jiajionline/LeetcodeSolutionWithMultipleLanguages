public class Solution {
    public int[] NextGreaterElements(int[] nums) {
        var ans = new int[nums.Length];
        Array.Fill(ans, -1);
        
        var stack = new Stack<int>();
        
        NextGreaterElements(nums, stack, ans);
        NextGreaterElements(nums, stack, ans);
        
        return ans;
    }
    
    private void NextGreaterElements(int[] nums, Stack<int> stack, int[] ans)
    {
        for(int i=0;i<nums.Length;i++)
        {
            while(stack.Count > 0 && nums[stack.Peek()] < nums[i])
            {
                ans[stack.Peek()] = nums[i];
                stack.Pop();
            }
            
            stack.Push(i);
        }
    }
}