public class Solution {
    public IList<IList<int>> CombinationSum2(int[] candidates, int target) {
        Array.Sort(candidates);
        var ans = new List<IList<int>>();
        DFS(candidates, target, 0, 0, new List<int>(), ans);
        return ans;
    }
    
    private void DFS(int[] candidates, int target, int sum, int index, IList<int> list, IList<IList<int>> ans)
    {
        if(sum == target)
            ans.Add(new List<int>(list));
        
        for(int i=index;i<candidates.Length;i++)
        {
            if(sum + candidates[i] > target) return;
            if(i > index && candidates[i] == candidates[i-1]) continue;
            list.Add(candidates[i]);
            DFS(candidates, target, sum + candidates[i], i+1, list, ans);
            list.RemoveAt(list.Count - 1);
        }
    }
}