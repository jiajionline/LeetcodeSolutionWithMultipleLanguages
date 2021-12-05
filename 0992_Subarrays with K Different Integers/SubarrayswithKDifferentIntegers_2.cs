public class Solution {
    public int SubarraysWithKDistinct(int[] nums, int k) {
        return SubarraysWithMostKDistinct(nums, k) - SubarraysWithMostKDistinct(nums, k-1);
    }
    
    
    public int SubarraysWithMostKDistinct(int[] nums, int k)
    {
        var dict = new Dictionary<int, int>();
        var l = 0;
        var ans = 0;
 
        for (int r = 0; r < nums.Length; r++)
        {
            if (!dict.ContainsKey(nums[r]))
                dict.Add(nums[r], 0);
            dict[nums[r]]++;
 
            while (dict.Count > k)
            {
                if (dict.ContainsKey(nums[l]))
                {
                    dict[nums[l]]--;
                    if (dict[nums[l]] == 0)
                        dict.Remove(nums[l]);
                    l++;
                }
            }
            ans += (r - l + 1);
        }
 
        return ans;
    }

}