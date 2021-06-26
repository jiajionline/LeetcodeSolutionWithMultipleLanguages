public class Solution {
    public IList<IList<int>> SubsetsWithDup(int[] nums) {
        var ans = new List<IList<int>>();
        if(nums == null || nums.Length == 0) return ans;
        Array.Sort(nums);
        DFS(nums, 0, new List<int>(), ans);
        
        return ans;
    }
    
    private void DFS(int[] nums, int s, IList<int> curr, IList<IList<int>> ans)
    {
        ans.Add(new List<int>(curr));
        for(int i=s;i<nums.Length;i++){
            if(i>s && nums[i] == nums[i-1]) continue;
            curr.Add(nums[i]);
            DFS(nums, i+1, curr, ans);
            curr.RemoveAt(curr.Count - 1);
        }
    }
}