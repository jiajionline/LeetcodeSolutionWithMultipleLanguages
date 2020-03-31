public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        var ans = new List<IList<int>>();
        if(nums == null || nums.Length == 0) return ans;
        
        for(int c=0;c<=nums.Length;c++){
            DFS(nums, 0, c, new List<int>(), ans);
        }
        
        return ans;
    }
    
    private void DFS(int[] nums, int s, int c, IList<int> curr, IList<IList<int>> ans)
    {
        if(curr.Count == c){
            ans.Add(new List<int>(curr));
            return;
        }
        
        for(int i=s;i<nums.Length;i++){
            curr.Add(nums[i]);
            DFS(nums, i+1, c, curr, ans);
            curr.RemoveAt(curr.Count - 1);
        }
    }
}