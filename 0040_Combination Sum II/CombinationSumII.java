class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        DFS(candidates, target, 0, curr, ans);
        return ans;
        
    }
    
    private void DFS(int[] candidates, int target, int s, List<Integer> curr, List<List<Integer>> ans){
        if(target == 0){
                ans.add(new ArrayList<Integer>(curr));
                return;
            }
        
        
        for(int i=s;i<candidates.length;i++){
             
            if(candidates[i] > target) break;
            if(i>s && candidates[i] == candidates[i-1]) continue;
            
            curr.add(candidates[i]);
            DFS(candidates, target - candidates[i], i+1, curr, ans);
            curr.remove(curr.size()-1);
        }
        
        
    }
}