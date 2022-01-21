public class Solution {
    public IList<IList<int>> CombinationSum2(int[] candidates, int target) {
        Array.Sort(candidates);
        var ans = new List<IList<int>>();
        DFS(candidates, target, 0, new List<int>(), ans);
        return ans;
    }
    
    private void DFS(int[] candidates, int target, int index, List<int> list, List<IList<int>> ans)
    {
        if(target == 0) 
        {
            ans.Add(new List<int>(list));
            return;
        }
        
        for(int i=index;i<candidates.Length;i++)
        {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            list.Add(candidates[i]);
            DFS(candidates, target - candidates[i], i+1, list, ans);
            list.RemoveAt(list.Count - 1);
        }
    }
}