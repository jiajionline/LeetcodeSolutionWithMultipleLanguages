public class Solution {
    public IList<IList<int>> PermuteUnique(int[] nums) {
        var ans = new List<IList<int>>();
        bool[] used = new bool[nums.Length];
        Array.Sort(nums);
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
            
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            curr.Add(nums[i]);
            used[i] = true;
            DFS(nums, used, curr, ans);
            curr.RemoveAt(curr.Count - 1);
            used[i] = false;
        }
    }
}