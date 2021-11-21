public class Solution {
    public IList<IList<int>> CombinationSum3(int k, int n) {
        var ans = new List<IList<int>>();
        DFS(k,n,1,0,new List<int>(), ans);
        return ans;
    }
    
    private void DFS(int k, int n, int index, int sum, List<int> list, List<IList<int>> ans)
    {
        if(list.Count == k)
        {
            if(sum == n)
                ans.Add(new List<int>(list));
            return;
        }
        
        for(int i=index;i<=9;i++)
        {
            list.Add(i);
            DFS(k,n,i+1,sum+i,list,ans);
            list.RemoveAt(list.Count-1);
        }
    }
}