public class Solution {
    public IList<IList<int>> CombinationSum3(int k, int n) {
        var ans = new List<IList<int>>();
        DFS(k,n,1,new List<int>(), ans);
        return ans;
    }
    
    private void DFS(int k, int n, int s, IList<int> curr, IList<IList<int>> ans){
        if(n == 0){
            if(curr.Count == k) ans.Add(new List<int>(curr));
            return;
        }
        
        for(int i=s;i<=9;i++){
            if(i > n) break;
            curr.Add(i);
            DFS(k,n-i,i+1,curr,ans);
            curr.RemoveAt(curr.Count - 1);
        }
    }
}