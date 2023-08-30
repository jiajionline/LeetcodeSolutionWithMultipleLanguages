class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        DFS(1,k,n,new ArrayList<Integer>(),ans);
        return ans;
    }
    
    private void DFS(int s, int k, int n, List<Integer> curr, List<List<Integer>> ans)
    {
        if(n == 0){
            if(curr.size() == k) ans.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for(int i=s;i<=9;i++){
            if(i > n) break;
            curr.add(i);
            DFS(i+1,k,n-i,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}