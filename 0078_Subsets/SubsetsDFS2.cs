public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        var ans = new List<IList<int>>();
        if(nums == null || nums.Length == 0) return ans;
        
        DFS(nums, 0, new List<int>(), ans);
        return ans;
    }
    
    private void DFS(int[] nums, int s, List<int> curr, IList<IList<int>> ans)
    {
        ans.Add(new List<int>(curr));
        for(int i=s;i<nums.Length;i++)
        {
            curr.Add(nums[i]);
            DFS(nums, i+1, curr, ans);
            curr.RemoveAt(curr.Count - 1);
        }
    }
}