public class Solution {
    public IList<IList<int>> SubsetsWithDup(int[] nums) {
        var ans = new List<IList<int>>();
        if(nums == null || nums.Length == 0) return ans;
        Array.Sort(nums);
        for(int c=0;c<=nums.Length;c++){
            DFS(nums, c, 0, new List<int>(), ans);
        }
        
        return ans;
    }
    
    private void DFS(int[] nums, int c, int s, IList<int> curr, IList<IList<int>> ans){
        if(curr.Count == c){
            ans.Add(new List<int>(curr));
            return;
        }
        
        for(int i=s;i<nums.Length;i++){
            if(i>s && nums[i] == nums[i-1]) continue;
            curr.Add(nums[i]);
            DFS(nums, c, i+1, curr, ans);
            curr.RemoveAt(curr.Count - 1);
        }
    }
}