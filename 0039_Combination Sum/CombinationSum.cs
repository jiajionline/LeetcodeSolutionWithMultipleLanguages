public class Solution {
    public IList<IList<int>> CombinationSum(int[] candidates, int target) {
        
        var ans = new List<IList<int>>();
        if(candidates == null || candidates.Length == 0) return ans;
        
        Array.Sort(candidates);
        DFS(candidates, 0, target, new List<int>(), ans);
        
        return ans;
    }
    
    private void DFS(int[] candidates, int s, int target, IList<int> list, IList<IList<int>> ans){
        
            if(target == 0){
                ans.Add(new List<int>(list));
                return;
            } 
                
        
        for(int i=s;i<candidates.Length;i++){
            if(candidates[i] > target) break;

            list.Add(candidates[i]);   
            DFS(candidates, i,target - candidates[i], list, ans);
            list.RemoveAt(list.Count - 1);
        }
    }
}