public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        var ans = new List<IList<int>>();
        
        for(int i=0;i< (1 << nums.Length);i++)
        {
            var list = new List<int>();
    
            for(int j=0;j<nums.Length;j++)
            {
                if((i & (1 << j)) > 0) list.Add(nums[j]);
            }
            
            ans.Add(list);
        }
        
        return ans;
    }
}