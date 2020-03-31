public class Solution {
    public IList<IList<int>> Combine(int n, int k) {
        var ans = new List<IList<int>>();
        DFS(n,k,1,new List<int>(), ans);
        return ans;
    }
    
    private void DFS(int n, int k, int s, IList<int> curr, IList<IList<int>> ans){
        if(curr.Count == k){
            ans.Add(new List<int>(curr));
            return;
        }
        
        for(int i=s;i<=n;i++){
            curr.Add(i);
            DFS(n,k,i+1,curr,ans);
            curr.RemoveAt(curr.Count - 1);
        }
    }
}