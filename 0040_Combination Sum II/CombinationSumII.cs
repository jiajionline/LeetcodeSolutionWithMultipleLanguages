public class Solution {
    public IList<IList<int>> CombinationSum2(int[] candidates, int target) {
        var ans = new List<IList<int>>();
        if(candidates == null || candidates.Length == 0) return ans;
        Array.Sort(candidates);
        DFS(candidates, target, 0, new List<int>(), ans);
        return ans;
    }
    
    private void DFS(int[] candidates, int target, int s, IList<int> curr, IList<IList<int>> ans){
        if(target == 0){
            ans.Add(new List<int>(curr));
            return;
        }
        
        for(int i=s;i<candidates.Length;i++){
            if(candidates[i] > target) break;
            if(i>s && candidates[i] == candidates[i-1]) continue;
            
            curr.Add(candidates[i]);
            DFS(candidates, target - candidates[i], i+1, curr, ans);
            curr.RemoveAt(curr.Count - 1);
        }
    }
}