public class Solution {
    public IList<IList<int>> Permute(int[] nums) {
        var ans = new List<IList<int>>();
        if(nums == null || nums.Length == 0) return ans;
        var used = new bool[nums.Length];
        DFS(nums, used, new List<int>(), ans);
        return ans;
    }
    
    private void DFS(int[] nums, bool[] used, IList<int> curr, IList<IList<int>> ans){
        if(curr.Count == nums.Length){
            ans.Add(new List<int>(curr));
            return;
        }
        
        for(int i=0;i<nums.Length;i++){
            if(used[i]) continue;
            used[i] = true;
            curr.Add(nums[i]);
            DFS(nums, used, curr, ans);
            used[i] = false;
            curr.RemoveAt(curr.Count - 1);
        }
    }
}