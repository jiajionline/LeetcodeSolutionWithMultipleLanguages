class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        
        DFS(1,k,n,curr,ans);
        return ans;
    }
    
    private void DFS(int s, int k, int n, List<Integer> curr, List<List<Integer>> ans)
    {
        if(curr.size() == k && n == 0){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        
        if(curr.size() == k) return;
        
        for(int i=s;i<=9;i++){
            curr.add(i);
            DFS(i+1,k,n-i,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}