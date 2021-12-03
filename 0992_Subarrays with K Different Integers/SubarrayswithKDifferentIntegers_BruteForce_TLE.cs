public class Solution {
    public int SubarraysWithKDistinct(int[] nums, int k) {
        var set = new HashSet<int>();
        var ans = 0;
        for(int i=0;i<nums.Length;i++)
        {
            set.Clear();
            for(int j=i;j<nums.Length;j++)
            {
                set.Add(nums[j]);
                if(set.Count == k)
                {
                    ans++;
                }
                
                if(set.Count > k) break;
            }
        }
        
        return ans;
    }
}