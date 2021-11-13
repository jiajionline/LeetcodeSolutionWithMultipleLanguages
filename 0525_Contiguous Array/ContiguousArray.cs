public class Solution {
    public int FindMaxLength(int[] nums) {
        if(nums == null || nums.Length <= 1) return 0;
        var dict = new Dictionary<int,int>();
        
        var sum = 0;
        var ans = 0;
        
        for(int i=0;i<nums.Length;i++)
        {
            sum += nums[i] > 0 ? 1 : -1;
            if(sum == 0)
            {
                ans = i + 1;
            }
            else if(dict.ContainsKey(sum))
            {
                ans = Math.Max(ans, i - dict[sum]);    
            }
            else
            {
                dict.Add(sum, i);
            }
        }
        
        return ans;
    }
}